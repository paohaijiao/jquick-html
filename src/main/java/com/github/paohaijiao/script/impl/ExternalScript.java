/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Copyright (c) [2025-2099] Martin (goudingcheng@gmail.com)
 */
package com.github.paohaijiao.script.impl;

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.model.AttrModel;
import com.github.paohaijiao.script.Script;

import java.util.Collections;
import java.util.List;

/**
 * 外部脚本：通过src引入外部.js文件
 */
public class ExternalScript implements Script {
    /**
     * 附加属性（如crossorigin）
     */
    private final AttrModel attributes = new AttrModel();
    /**
     * 外部脚本路径（getContent()返回此值）
     */
    private String src;
    private Script.LoadStrategy loadStrategy = Script.LoadStrategy.NONE;
    /**
     * 加载完成回调（onload事件）
     */
    private String onLoad;

    public ExternalScript(String src) {
        this.src = src;
    }

    @Override
    public String getScriptType() {
        return "external";
    }

    @Override
    public String getContent() {
        return src;
    }

    @Override
    public void setContent(String content) {
        this.src = content; // 外部脚本的content即src路径
    }

    @Override
    public Script.LoadStrategy getLoadStrategy() {
        return loadStrategy;
    }

    @Override
    public void setLoadStrategy(Script.LoadStrategy strategy) {
        this.loadStrategy = strategy != null ? strategy : Script.LoadStrategy.NONE;
    }

    @Override
    public String getOnLoad() {
        return onLoad;
    }

    @Override
    public void setOnLoad(String handler) {
        this.onLoad = handler;
    }





    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("<script");
        sb.append(" src=\"").append(src).append("\"");
        if (!loadStrategy.getAttribute().isEmpty()) {
            sb.append(" ").append(loadStrategy.getAttribute());
        }
        if (onLoad != null && !onLoad.isEmpty()) {
            sb.append(" onload=\"").append(onLoad).append("\"");
        }
        if (!attributes.isEmpty()) {
            sb.append(" ").append(attributes);
        }
        sb.append("></script>");
        return sb.toString();
    }
}

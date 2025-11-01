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
 * 内联脚本：在<script>标签内直接编写JavaScript代码
 */
public class InlineScript implements Script {
    private final com.github.paohaijiao.model.AttrModel attributes = new AttrModel(); // 附加属性（如type="module"）
    /**
     * 内联JavaScript代码
     */
    private String code;
    private Script.LoadStrategy loadStrategy = Script.LoadStrategy.NONE;

    public InlineScript() {
        this.code = "";
    }

    public InlineScript(String code) {
        this.code = code;
    }

    @Override
    public String getScriptType() {
        return "inline";
    }

    @Override
    public String getContent() {
        return code;
    }

    /**
     * 内联脚本的content即代码
     *
     * @param content
     */
    @Override
    public void setContent(String content) {
        this.code = content;
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
        return attributes.get("onload");
    }

    /**
     * 内联脚本一般无需onload（同步执行），但可通过属性添加
     *
     * @param handler
     */
    @Override
    public void setOnLoad(String handler) {
        // attributes.add("onload", handler);
    }

    /**
     * 添加JavaScript代码片段（追加到现有代码）
     */
    public void appendCode(String codeSnippet) {
        this.code += "\n" + codeSnippet;
    }



//
//    @Override
//    public AttrModel getAttribute() {
//        return attributes;
//    }
//
//    @Override
//    public void setAttribute(AttrModel attribute) {
//        if (attribute != null) {
//            attributes.addAll(attribute.getAttributes());
//        }
//    }

    /**
     * 加载策略（async/defer）
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("<script");
        if (!loadStrategy.getAttribute().isEmpty()) {
            sb.append(" ").append(loadStrategy.getAttribute());
        }
        if (!attributes.isEmpty()) {// 附加属性（如type="module"）
            sb.append(" ").append(attributes);
        }
        sb.append(">").append(escapeCode(code)).append("</script>"); // 内联代码（注意转义特殊字符）
        return sb.toString();
    }

    /**
     * 转义JavaScript代码中的特殊字符（如</script>会导致标签提前闭合）
     */
    private String escapeCode(String code) {
        if (code == null) return "";
        return code.replace("</script>", "<\\/script>");
    }
}

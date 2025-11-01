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
package com.github.paohaijiao.dom.h2.impl;

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.dom.abs.AbsDom;
import com.github.paohaijiao.dom.h2.H2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 二级标题（<h2>）的具体实现类
 * HTML 中 h2 元素的特性，用于页面次级标题（如章节标题）
 */
public class H2Impl extends AbsDom implements H2 {

    /**
     * 子元素（支持嵌套行内元素，如 <h2>第二章：<span>接口设计</span></h2>）
     */
    private final List<Dom> children = new ArrayList<>();
    /**
     * 标题文本内容
     */
    private String text;


    /**
     * 获取标题文本内容
     */
    @Override
    public String getText() {
        return text;
    }

    /**
     * 设置标题文本内容
     */
    @Override
    public void setText(String text) {
        this.text = text;
    }

    /**
     * 获取标题级别（固定为 2，对应 h2）
     */
    @Override
    public int getLevel() {
        return 2;
    }

    /**
     * 获取节点名称（固定为 "h2"，对应 HTML 标签名）
     */
    @Override
    public String getNodeType() {
        return "h2";
    }

    /**
     * 添加子元素（支持行内元素如 span、a、i 等，用于局部样式或链接）
     */
    @Override
    public void addChild(Dom child) {
        if (child != null) {
            children.add(child);
        }
    }

    /**
     * 获取所有子元素（不可修改列表）
     */
    @Override
    public List<Dom> getChildren() {
        return Collections.unmodifiableList(new ArrayList<>(children));
    }





    /**
     * 生成 HTML 标签的字符串
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<h2");
        if(null!=attributes && !attributes.isEmpty()) {
            sb.append(" ").append(toAttrString());
        }
        if(null!=style && !style.isEmpty()) {
            sb.append(" ").append(toStyleString());
        }
        sb.append(">");
        if (text != null && !text.isEmpty()) {
            sb.append(text);
        }
        for (Dom child : children) {
            sb.append(child.toString());
        }
        sb.append("</h2>");
        return prettyPrint(sb.toString());
    }
}

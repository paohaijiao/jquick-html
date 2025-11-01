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
package com.github.paohaijiao.dom.span.impl;

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.dom.abs.AbsDom;
import com.github.paohaijiao.dom.span.Span;
import com.github.paohaijiao.enums.DomEnums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 行内文本容器（<span>）的具体实现类
 * HTML 中 span 元素的特性，用于行内文本的局部样式控制或分组
 */
public class SpanImpl extends AbsDom implements Span {
    /**
     * 获取节点名称（固定为 "span"，对应 HTML 标签名）
     */
    @Override
    public String getNodeType() {
        return DomEnums.span.getCode();
    }

    /**
     * 子元素（支持嵌套行内元素，如 <span>这是<i>斜体</i>文本</span>）
     */
    private final List<Dom> children = new ArrayList<>();
    /**
     * 文本内容（行内文本片段）
     */
    private String text;


    /**
     * 获取行内文本内容
     */
    @Override
    public String getText() {
        return text;
    }

    /**
     * 设置行内文本内容
     */
    @Override
    public void setText(String text) {
        this.text = text;
    }




    /**
     * 添加子元素（支持行内元素如 i、b、a 等，用于嵌套样式）
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
        sb.append("<span");

        if (style != null && !style.isEmpty()) {
            sb.append(" style=\"").append(style).append("\"");
        }
        sb.append(">");
        if (text != null && !text.isEmpty()) {
            sb.append(text);
        }
        for (Dom child : children) {
            sb.append(child.toString());
        }
        sb.append("</span>");
        return prettyPrint(sb.toString());
    }
}
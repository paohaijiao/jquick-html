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
package com.github.paohaijiao.node.span.impl;

import com.github.paohaijiao.common.Node;
import com.github.paohaijiao.node.span.Span;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 行内文本容器（<span>）的具体实现类
 * HTML 中 span 元素的特性，用于行内文本的局部样式控制或分组
 */
public class SpanImpl implements Span {

    /**
     * 子元素（支持嵌套行内元素，如 <span>这是<i>斜体</i>文本</span>）
     */
    private final List<Node> children = new ArrayList<>();
    /**
     * 文本内容（行内文本片段）
     */
    private String text;
    /**
     * 通用属性：CSS 类名（用于局部样式控制，如文本颜色、字体等）
     */
    private String className;
    /**
     * 通用属性：唯一标识（用于脚本操作或样式锚点）
     */
    private String id;
    /**
     * 内联样式（如 "color: blue; font-weight: bold"，优先级高于外部样式）
     */
    private String style;

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
     * 获取节点名称（固定为 "span"，对应 HTML 标签名）
     */
    @Override
    public String getNodeName() {
        return "span";
    }

    /**
     * 添加子元素（支持行内元素如 i、b、a 等，用于嵌套样式）
     */
    @Override
    public void addChild(Node child) {
        if (child != null) {
            children.add(child);
        }
    }

    /**
     * 获取所有子元素（不可修改列表）
     */
    @Override
    public List<Node> getChildren() {
        return Collections.unmodifiableList(new ArrayList<>(children));
    }

    public String getClassName() {
        return className;
    }

    /**
     * 设置 CSS 类名（如 "highlight"、"text-warning"、"badge"）
     * 用于对局部文本进行样式控制（如高亮、颜色标记、徽章效果等）
     */
    public void setClassName(String className) {
        this.className = className;
    }

    public String getId() {
        return id;
    }

    /**
     * 设置唯一标识（用于脚本操作，如动态修改局部文本样式或内容）
     */
    public void setId(String id) {
        this.id = id;
    }

    public String getStyle() {
        return style;
    }

    /**
     * 设置内联样式（格式："属性1:值1; 属性2:值2"）
     * 用于快速定义局部文本样式（如临时调整颜色、字体大小）
     */
    public void setStyle(String style) {
        this.style = style;
    }


    /**
     * 生成 HTML 标签的字符串
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<span");
        if (id != null && !id.isEmpty()) {
            sb.append(" id=\"").append(id).append("\"");
        }
        if (className != null && !className.isEmpty()) {
            sb.append(" class=\"").append(className).append("\"");
        }
        if (style != null && !style.isEmpty()) {
            sb.append(" style=\"").append(style).append("\"");
        }
        sb.append(">");
        if (text != null && !text.isEmpty()) {
            sb.append(text);
        }
        for (Node child : children) {
            sb.append(child.toString());
        }
        sb.append("</span>");
        return sb.toString();
    }
}
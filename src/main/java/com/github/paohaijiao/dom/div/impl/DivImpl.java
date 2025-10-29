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
package com.github.paohaijiao.dom.div.impl;

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.dom.div.Div;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 通用块级容器（<div>）的具体实现类
 * HTML 中 div 元素的通用容器特性，用于页面布局和内容分组
 */
public class DivImpl implements Div {
    /**
     * 存储子元素（可包含任何 Node 类型，如 p、span、button、其他 div 等）
     */
    private final List<Dom> children = new ArrayList<>();
    /**
     * 自定义数据属性（用于存储页面私有数据，如 data-id、data-type 等）
     */
    private final List<String> dataAttributes = new ArrayList<>();
    /**
     * CSS 类名（用于关联外部样式表，支持多个类名用空格分隔）
     */
    private String className;
    /**
     * 唯一标识（用于 DOM 定位、脚本操作或样式锚点）
     */
    private String id;
    /**
     * 内联样式（如 "color: red; font-size: 16px"）
     */
    private String style;

    /**
     * 添加子元素到 div 中（div 作为通用容器，支持任意子节点）
     */
    @Override
    public void addElement(Dom element) {
        if (element != null) {
            children.add(element);
        }
    }

    /**
     * 从 div 中移除指定子元素
     */
    @Override
    public boolean removeElement(Dom element) {
        return children.remove(element);
    }

    /**
     * 获取所有子元素（返回不可修改副本，避免外部直接修改内部集合）
     */
    @Override
    public List<Dom> getElements() {
        return Collections.unmodifiableList(new ArrayList<>(children));
    }

    /**
     * 获取节点名称（固定为 "div"，对应 HTML 标签名）
     */
    @Override
    public String getNodeName() {
        return "div";
    }

    /**
     * 实现 Node 接口的 addChild 方法（与 addElement 功能一致，保持接口兼容性）
     */
    @Override
    public void addChild(Dom child) {
        addElement(child);
    }

    /**
     * 实现 Node 接口的 getChildren 方法（与 getElements 一致，保持接口兼容性）
     */
    @Override
    public List<Dom> getChildren() {
        return getElements();
    }

    @Override
    public String getClassName() {
        return className;
    }

    /**
     * 设置 CSS 类名，支持多个类名（如 "container flex justify-center"）
     */
    @Override
    public void setClassName(String className) {
        this.className = className;
    }

    public String getId() {
        return id;
    }

    /**
     * 设置唯一标识，用于通过 ID 选择器定位元素（如 CSS 中的 #id 或 JS 中的 getElementById）
     */
    public void setId(String id) {
        this.id = id;
    }

    public String getStyle() {
        return style;
    }

    /**
     * 设置内联样式，优先级高于外部样式表（格式："属性1:值1; 属性2:值2"）
     */
    public void setStyle(String style) {
        this.style = style;
    }

    /**
     * 添加自定义数据属性（如 data-user-id="123"）
     * 符合 HTML5 data-* 规范，用于存储页面逻辑所需的额外数据
     */
    public void addDataAttribute(String key, String value) {
        if (key != null && !key.isEmpty() && value != null) {
            dataAttributes.add("data-" + key + "=\"" + value + "\"");
        }
    }

    /**
     * 获取所有自定义数据属性
     */
    public List<String> getDataAttributes() {
        return Collections.unmodifiableList(dataAttributes);
    }


    /**
     * 生成 HTML 标签的字符串，包含所有属性和子元素
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<div");
        if (id != null && !id.isEmpty()) {
            sb.append(" id=\"").append(id).append("\"");
        }
        if (className != null && !className.isEmpty()) {
            sb.append(" class=\"").append(className).append("\"");
        }
        if (style != null && !style.isEmpty()) {
            sb.append(" style=\"").append(style).append("\"");
        }
        for (String dataAttr : dataAttributes) {
            sb.append(" ").append(dataAttr);
        }
        sb.append(">");
        for (Dom child : children) {
            sb.append("\n  ").append(child.toString().replace("\n", "\n  "));
        }
        sb.append("\n</div>");
        return sb.toString();
    }
}

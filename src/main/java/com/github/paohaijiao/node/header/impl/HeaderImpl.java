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
package com.github.paohaijiao.node.header.impl;

import com.github.paohaijiao.common.Node;
import com.github.paohaijiao.node.header.Header;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 页头元素（<header>）的具体实现类
 * HTML 中 header 元素的特性，作为页面或区块的头部容器（如网站头部、文章头部）
 */
public class HeaderImpl implements Header {

    /**
     * 存储头部内的子元素（如 Logo、标题、导航菜单、搜索框等）
     */
    private final List<Node> children = new ArrayList<>();

    /**
     * 通用属性：CSS 类名（用于样式控制，如布局、背景等）
     */
    private String className;

    /**
     * 通用属性：唯一标识（用于脚本操作或样式锚点）
     */
    private String id;

    /**
     * 可选：无障碍标签（ARIA 属性），描述头部用途（提升可访问性）
     */
    private String ariaLabel;


    /**
     * 添加子元素到头部容器中
     * 例如：添加 Logo 图片（img）、网站标题（h1）、导航菜单（nav/ul）等
     */
    @Override
    public void addElement(Node element) {
        if (element != null) {
            children.add(element);
        }
    }

    /**
     * 从头部容器中移除指定子元素
     */
    @Override
    public boolean removeElement(Node element) {
        return children.remove(element);
    }

    /**
     * 获取头部容器中所有子元素（返回不可修改副本，避免外部直接修改内部集合）
     */
    @Override
    public List<Node> getElements() {
        return Collections.unmodifiableList(new ArrayList<>(children));
    }

    /**
     * 获取节点名称（固定为 "header"，对应 HTML 标签名）
     */
    @Override
    public String getNodeName() {
        return "header";
    }

    /**
     * 实现 Node 接口的 addChild 方法（与 addElement 功能一致，保持接口兼容性）
     */
    @Override
    public void addChild(Node child) {
        addElement(child);
    }

    /**
     * 实现 Node 接口的 getChildren 方法（与 getElements 一致，保持接口兼容性）
     */
    @Override
    public List<Node> getChildren() {
        return getElements();
    }

    public String getClassName() {
        return className;
    }

    /**
     * 设置 CSS 类名（如 "site-header"、"article-header"、"sticky-header"）
     * 用于控制头部的布局（如固定顶部、响应式调整）和样式
     */
    public void setClassName(String className) {
        this.className = className;
    }

    public String getId() {
        return id;
    }

    /**
     * 设置唯一标识（用于脚本定位或样式锚点，如通过 JS 控制头部滚动效果）
     */
    public void setId(String id) {
        this.id = id;
    }

    public String getAriaLabel() {
        return ariaLabel;
    }

    /**
     * 设置无障碍标签（ARIA 属性），描述头部的用途（提升可访问性）
     * 例如："网站顶部导航"、"文章标题区域" 等
     */
    public void setAriaLabel(String ariaLabel) {
        this.ariaLabel = ariaLabel;
    }


    /**
     * 生成 HTML 标签的字符串，包含所有属性和子元素
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<header");
        if (id != null && !id.isEmpty()) {
            sb.append(" id=\"").append(id).append("\"");
        }
        if (className != null && !className.isEmpty()) {
            sb.append(" class=\"").append(className).append("\"");
        }
        if (ariaLabel != null && !ariaLabel.isEmpty()) {
            sb.append(" aria-label=\"").append(ariaLabel).append("\"");
        }
        sb.append(">");
        for (Node child : children) {
            sb.append("\n  ").append(child.toString().replace("\n", "\n  "));
        }
        sb.append("\n</header>");
        return sb.toString();
    }
}
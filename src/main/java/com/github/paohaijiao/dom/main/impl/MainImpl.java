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
package com.github.paohaijiao.dom.main.impl;

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.dom.main.Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 主要内容区域（<main>）的具体实现类
 * HTML 中 main 元素的特性，用于承载页面的核心内容（一个页面通常只应有一个 main 元素）
 */
public class MainImpl implements Main {

    /**
     * 存储主要内容区域内的子元素（如文章、表单、列表、区块等核心内容）
     */
    private final List<Dom> children = new ArrayList<>();

    /**
     * 通用属性：CSS 类名（用于样式控制，如布局、背景、内边距等）
     */
    private String className;

    /**
     * 通用属性：唯一标识（用于脚本操作或样式锚点）
     */
    private String id;

    /**
     * 可选：无障碍标签（ARIA 属性），描述主要内容的用途（提升可访问性）
     */
    private String ariaLabel;


    /**
     * 添加子元素到主要内容区域中
     * 例如：添加文章内容（article）、表单（form）、数据表格（table）、主要区块（div）等
     */
    @Override
    public void addElement(Dom element) {
        if (element != null) {
            children.add(element);
        }
    }

    /**
     * 从主要内容区域中移除指定子元素
     */
    @Override
    public boolean removeElement(Dom element) {
        return children.remove(element);
    }

    /**
     * 获取主要内容区域中所有子元素（返回不可修改副本，避免外部直接修改内部集合）
     */
    @Override
    public List<Dom> getElements() {
        return Collections.unmodifiableList(new ArrayList<>(children));
    }

    /**
     * 获取节点名称（固定为 "main"，对应 HTML 标签名）
     */
    @Override
    public String getNodeType() {
        return "main";
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

    public String getClassName() {
        return className;
    }

    /**
     * 设置 CSS 类名（如 "main-content"、"container"、"flex-grow"）
     * 用于控制主要内容的布局（如居中显示、响应式调整）和样式（如背景色、边距）
     */
    public void setClassName(String className) {
        this.className = className;
    }

    public String getId() {
        return id;
    }

    /**
     * 设置唯一标识（用于脚本操作，如动态加载主要内容、监听滚动事件等）
     */
    public void setId(String id) {
        this.id = id;
    }

    public String getAriaLabel() {
        return ariaLabel;
    }

    /**
     * 设置无障碍标签（ARIA 属性），描述主要内容的用途（提升可访问性）
     * 例如："文章正文"、"产品列表"、"用户中心主页" 等
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
        sb.append("<main");
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
        for (Dom child : children) {
            sb.append("\n  ").append(child.toString().replace("\n", "\n  "));
        }
        sb.append("\n</main>");
        return sb.toString();
    }
}

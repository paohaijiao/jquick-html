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
package com.github.paohaijiao.dom.label.impl;

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.dom.abs.AbsDom;
import com.github.paohaijiao.dom.label.Label;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 标签元素（<label>）的具体实现类
 * HTML 中 label 元素的特性，用于关联表单控件，提升可访问性和交互性
 */
public class LabelImpl extends AbsDom implements Label {

    /**
     * 子元素（支持嵌套行内元素，如 <label>用户名：<span class="required">*</span></label>）
     */
    private final List<Dom> children = new ArrayList<>();
    /**
     * 标签显示文本
     */
    private String text;
    /**
     * 关联的表单控件 ID（通过 for 属性绑定，点击标签会触发关联控件的焦点/选中）
     */
    private String forId;
    /**
     * 通用属性：CSS 类名（用于样式控制，如标签文本颜色、字体等）
     */
    private String className;
    /**
     * 通用属性：唯一标识（用于脚本操作或样式锚点）
     */
    private String id;

    /**
     * 获取标签显示文本
     */
    @Override
    public String getText() {
        return text;
    }

    /**
     * 设置标签显示文本
     */
    @Override
    public void setText(String text) {
        this.text = text;
    }

    /**
     * 获取关联的表单控件 ID
     */
    @Override
    public String getFor() {
        return forId;
    }

    /**
     * 设置关联的表单控件 ID（对应 for 属性）
     * 点击标签时，浏览器会自动将焦点转移到该 ID 的控件上
     */
    @Override
    public void setFor(String elementId) {
        this.forId = elementId;
    }

    /**
     * 获取节点名称（固定为 "label"，对应 HTML 标签名）
     */
    @Override
    public String getNodeType() {
        return "label";
    }

    /**
     * 添加子元素（支持行内元素如 span、i、a 等，用于丰富标签内容）
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

    public String getClassName() {
        return className;
    }

    /**
     * 设置 CSS 类名（如 "form-label"、"required-label"）
     * 用于控制标签样式（与表单控件对齐、必填项标记样式等）
     */
    public void setClassName(String className) {
        this.className = className;
    }

    public String getId() {
        return id;
    }

    /**
     * 设置唯一标识（用于脚本操作，如动态修改标签文本或样式）
     */
    public void setId(String id) {
        this.id = id;
    }


    /**
     * 生成 HTML 标签的字符串
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<label");
        if (id != null && !id.isEmpty()) {
            sb.append(" id=\"").append(id).append("\"");
        }
        if (className != null && !className.isEmpty()) {
            sb.append(" class=\"").append(className).append("\"");
        }
        if (forId != null && !forId.isEmpty()) {
            sb.append(" for=\"").append(forId).append("\""); // 核心关联属性
        }
        sb.append(">");
        if (text != null && !text.isEmpty()) {
            sb.append(text);
        }
        for (Dom child : children) {
            sb.append(child.toString());
        }
        sb.append("</label>");
        return prettyPrint(sb.toString());
    }
}
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
package com.github.paohaijiao.dom.option.impl;

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.dom.abs.AbsDom;
import com.github.paohaijiao.dom.option.Option;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 下拉列表选项（<option>）的具体实现类
 * HTML 中 option 元素的特性，作为 select 下拉列表的子项，提供可选值
 */
public class OptionImpl extends AbsDom implements Option {

    /**
     * 子元素（option 通常仅包含文本，此处预留但实际很少使用）
     */
    private final List<Dom> children = new ArrayList<>();
    /**
     * 选项显示文本（用户可见的内容）
     */
    private String text;
    /**
     * 选项对应的值（表单提交时实际发送的值，通常与 text 不同）
     */
    private String value;
    /**
     * 选项是否被选中（默认选中状态）
     */
    private boolean selected;
    /**
     * 选项是否禁用（禁用后不可选）
     */
    private boolean disabled;
    /**
     * 通用属性：CSS 类名（用于样式控制，如选中/禁用状态的样式）
     */
    private String className;
    /**
     * 通用属性：唯一标识（用于脚本操作或样式锚点）
     */
    private String id;

    /**
     * 获取选项显示文本
     */
    @Override
    public String getText() {
        return text;
    }

    /**
     * 设置选项显示文本（用户可见）
     */
    @Override
    public void setText(String text) {
        this.text = text;
    }

    /**
     * 获取选项对应的值
     */
    @Override
    public String getValue() {
        return value;
    }

    /**
     * 设置选项对应的值（表单提交时使用）
     */
    @Override
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 判断选项是否默认选中
     */
    @Override
    public boolean isSelected() {
        return selected;
    }

    /**
     * 设置选项是否默认选中
     */
    @Override
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    /**
     * 判断选项是否禁用
     */
    public boolean isDisabled() {
        return disabled;
    }

    /**
     * 设置选项是否禁用（禁用后不可交互）
     */

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    /**
     * 获取节点名称（固定为 "option"，对应 HTML 标签名）
     */
    @Override
    public String getNodeType() {
        return "option";
    }

    /**
     * 添加子元素（极少使用，option 通常仅包含文本）
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
        return Collections.unmodifiableList(children);
    }

    public String getClassName() {
        return className;
    }

    /**
     * 设置 CSS 类名（如 "option-highlight"、"option-disabled"）
     * 用于控制选项样式（如选中项高亮、禁用项灰显等）
     */
    public void setClassName(String className) {
        this.className = className;
    }

    public String getId() {
        return id;
    }

    /**
     * 设置唯一标识（用于脚本操作，如动态修改选项状态）
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
        sb.append("<option");
        if (id != null && !id.isEmpty()) {
            sb.append(" id=\"").append(id).append("\"");
        }
        if (className != null && !className.isEmpty()) {
            sb.append(" class=\"").append(className).append("\"");
        }
        if (value != null && !value.isEmpty()) {
            sb.append(" value=\"").append(value).append("\"");
        }
        if (selected) {
            sb.append(" selected");
        }
        if (disabled) {
            sb.append(" disabled");
        }
        sb.append(">");

        if (text != null && !text.isEmpty()) {
            sb.append(text);
        }
        for (Dom child : children) {
            sb.append(child.toString());
        }
        sb.append("</option>");
        return prettyPrint(sb.toString());
    }
}

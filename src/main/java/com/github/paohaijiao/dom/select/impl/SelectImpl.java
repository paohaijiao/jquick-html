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
package com.github.paohaijiao.dom.select.impl;

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.dom.option.Option;
import com.github.paohaijiao.dom.select.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 下拉列表容器（<select>）的具体实现类
 * HTML 中 select 元素的特性，用于承载 option 选项，提供用户选择交互
 */
public class SelectImpl implements Select {

    /**
     * 存储下拉列表中的选项（option 元素集合）
     */
    private final List<Option> options = new ArrayList<>();
    /**
     * 子元素（select 主要子元素是 option，此处实现 Node 接口兼容性）
     */
    private final List<Dom> children = new ArrayList<>();
    /**
     * 表单控件名称（用于表单提交时标识该字段）
     */
    private String name;
    /**
     * 通用属性：CSS 类名（用于样式控制，如下拉框边框、背景等）
     */
    private String className;
    /**
     * 通用属性：唯一标识（用于脚本操作或样式锚点）
     */
    private String id;
    /**
     * 是否允许多选（multiple 属性，true 时可按住 Ctrl 选择多个选项）
     */
    private boolean multiple;
    /**
     * 禁用状态（禁用后不可交互）
     */
    private boolean disabled;
    /**
     * 最多可见选项数（size 属性，控制下拉框高度）
     */
    private int size;
    private int selectIndex;

    /**
     * 添加选项到下拉列表中
     */
    @Override
    public void addOption(Option option) {
        if (option != null) {
            options.add(option);
            children.add(option); // 同步添加到子元素列表（满足 Node 接口）
        }
    }

    /**
     * 从下拉列表中移除指定选项
     */
    public boolean removeOption(Option option) {
        if (option != null) {
            children.remove(option); // 同步从子元素列表移除
            return options.remove(option);
        }
        return false;
    }

    /**
     * 获取所有选项（不可修改列表）
     */
    @Override
    public List<Option> getOptions() {
        return Collections.unmodifiableList(new ArrayList<>(options));
    }

    @Override
    public int getSelectedIndex() {
        return this.selectIndex;
    }

    @Override
    public void setSelectedIndex(int index) {
        this.selectIndex = index;
    }

    /**
     * 获取表单控件名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置表单控件名称（name 属性，表单提交时使用）
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 判断是否允许多选
     */
    @Override
    public boolean isMultiple() {
        return multiple;
    }

    /**
     * 设置是否允许多选
     */
    @Override
    public void setMultiple(boolean multiple) {
        this.multiple = multiple;
    }

    /**
     * 判断是否禁用
     */
    public boolean isDisabled() {
        return disabled;
    }

    /**
     * 设置是否禁用
     */
    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    /**
     * 获取可见选项数量
     */
    public int getSize() {
        return size;
    }

    /**
     * 设置可见选项数量（控制下拉框高度）
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * 添加子元素（实际是添加 option，与 addOption 功能一致，满足 Node 接口）
     */
    @Override
    public void addChild(Dom child) {
        if (child instanceof Option) {
            addOption((Option) child);
        }
    }

    /**
     * 获取所有子元素（返回 option 集合，满足 Node 接口）
     */
    @Override
    public List<Dom> getChildren() {
        return Collections.unmodifiableList(new ArrayList<>(children));
    }


    public String getClassName() {
        return className;
    }

    /**
     * 设置 CSS 类名（如 "form-select"、"custom-select"）
     * 用于控制下拉框样式（边框、圆角、背景色等）
     */
    public void setClassName(String className) {
        this.className = className;
    }

    public String getId() {
        return id;
    }

    /**
     * 设置唯一标识（用于与 label 关联或脚本操作，如获取选中值）
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
        sb.append("<select");
        if (id != null && !id.isEmpty()) {
            sb.append(" id=\"").append(id).append("\"");
        }
        if (className != null && !className.isEmpty()) {
            sb.append(" class=\"").append(className).append("\"");
        }
        if (name != null && !name.isEmpty()) {
            sb.append(" name=\"").append(name).append("\"");
        }
        if (multiple) {
            sb.append(" multiple");
        }
        if (disabled) {
            sb.append(" disabled");
        }
        if (size > 0) {
            sb.append(" size=\"").append(size).append("\"");
        }
        sb.append(">");
        for (Option option : options) {
            sb.append("\n  ").append(option.toString().replace("\n", "\n  "));
        }
        sb.append("\n</select>");
        return sb.toString();
    }
}
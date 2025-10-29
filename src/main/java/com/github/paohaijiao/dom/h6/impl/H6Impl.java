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
package com.github.paohaijiao.dom.h6.impl;

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.dom.heading.Heading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 六级标题（<h6>）的具体实现类
 * HTML 中 h6 元素的特性，作为标题层级中的最低级别，用于最细致的内容划分
 */
public class H6Impl implements Heading {

    /**
     * 子元素（支持嵌套行内元素，如 <h6>备注：<span>可选参数</span></h6>
     */
    private final List<Dom> children = new ArrayList<>();
    /**
     * 标题文本内容
     */
    private String text;
    /**
     * 通用属性：CSS 类名（用于样式控制，如字体大小、颜色等）
     */
    private String className;
    /**
     * 通用属性：唯一标识（用于锚点定位或脚本操作）
     */
    private String id;
    /**
     * 文本对齐方式（left/center/right，默认左对齐）
     */
    private String align;

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
     * 获取标题级别（固定为 6，对应 h6）
     */
    @Override
    public int getLevel() {
        return 6;
    }

    /**
     * 获取节点名称（固定为 "h6"，对应 HTML 标签名）
     */
    @Override
    public String getNodeType() {
        return "h6";
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

    public String getClassName() {
        return className;
    }

    /**
     * 设置 CSS 类名（如 "minisection-title"、"text-senary"）
     * 用于控制六级标题的样式（通常是标题层级中最小的）
     */
    public void setClassName(String className) {
        this.className = className;
    }

    public String getId() {
        return id;
    }

    /**
     * 设置唯一标识（用于最细粒度的锚点跳转，如 <a href="#note-2-1-1-1-1">跳转到备注</a>）
     */
    public void setId(String id) {
        this.id = id;
    }

    public String getAlign() {
        return align;
    }

    /**
     * 设置文本对齐方式：
     * - left：左对齐（默认）
     * - center：居中对齐
     * - right：右对齐
     */
    public void setAlign(String align) {
        this.align = align;
    }


    /**
     * 生成 HTML 标签的字符串
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<h6");
        if (id != null && !id.isEmpty()) {
            sb.append(" id=\"").append(id).append("\"");
        }
        if (className != null && !className.isEmpty()) {
            sb.append(" class=\"").append(className).append("\"");
        }
        if (align != null && !align.isEmpty()) {
            sb.append(" align=\"").append(align).append("\"");
        }
        sb.append(">");
        if (text != null && !text.isEmpty()) {
            sb.append(text);
        }
        for (Dom child : children) {
            sb.append(child.toString());
        }
        sb.append("</h6>");
        return sb.toString();
    }
}
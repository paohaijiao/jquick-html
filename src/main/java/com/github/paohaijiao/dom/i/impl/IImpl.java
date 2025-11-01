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
package com.github.paohaijiao.dom.i.impl;

/**
 * packageName com.github.paohaijiao.node.i.impl
 *
 * @author Martin
 * @version 1.0.0
 * @since 2025/10/28
 */

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.dom.abs.AbsDom;
import com.github.paohaijiao.dom.i.I;
import com.github.paohaijiao.enums.DomEnums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 斜体/图标元素（<i>）的具体实现类
 * HTML 中 i 元素的特性，用于斜体文本或作为图标容器（如配合 Font Awesome 等图标库）
 */
public class IImpl extends AbsDom implements I {

    /**
     * 子元素（较少使用，通常用于复杂图标组合或嵌套行内元素）
     */
    private final List<Dom> children = new ArrayList<>();
    /**
     * 元素内文本内容（斜体文本或图标辅助说明）
     */
    private String text;


    /**
     * 获取元素内的文本内容
     */
    @Override
    public String getText() {
        return text;
    }

    /**
     * 设置元素内的文本内容（斜体文本或图标相关说明）
     */
    @Override
    public void setText(String text) {
        this.text = text;
    }

    /**
     * 获取节点名称（固定为 "i"，对应 HTML 标签名）
     */
    @Override
    public String getNodeType() {
        return DomEnums.i.getCode();
    }

    /**
     * 添加子元素（极少使用，仅用于特殊场景如嵌套图标或标记）
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
        sb.append("<i");
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
        sb.append("</i>");
        return prettyPrint(sb.toString());
    }
}

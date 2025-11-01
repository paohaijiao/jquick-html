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
package com.github.paohaijiao.dom.p.impl;

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.dom.abs.AbsDom;
import com.github.paohaijiao.dom.p.P;
import com.github.paohaijiao.enums.DomEnums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 段落元素（<p>）的具体实现类
 * HTML 中 p 元素的特性，用于展示段落文本，支持行内元素嵌套
 */
public class PImpl extends AbsDom implements P {

    /**
     * 子元素（支持行内元素，如 <p>这是一个<a>链接</a>段落</p>）
     */
    private final List<Dom> children = new ArrayList<>();
    /**
     * 段落文本内容（基础文本，可与子元素混合展示）
     */
    private String text;

    /**
     * 获取段落文本内容
     */
    @Override
    public String getText() {
        return text;
    }

    /**
     * 设置段落文本内容
     */
    @Override
    public void setText(String text) {
        this.text = text;
    }

    /**
     * 获取节点名称（固定为 "p"，对应 HTML 标签名）
     */
    @Override
    public String getNodeType() {
        return DomEnums.p.getCode();
    }

    /**
     * 添加子元素（支持行内元素如 a、span、i 等，用于丰富段落内容）
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
        sb.append("<p");
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
        sb.append("</p>");
        return prettyPrint(sb.toString());
    }
}

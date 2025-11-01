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
package com.github.paohaijiao.dom.li.impl;

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.dom.abs.AbsDom;
import com.github.paohaijiao.dom.li.Li;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 列表项元素（<li>）的具体实现类
 * HTML 中 li 元素的特性，作为 ul/ol 列表的子项，展示列表内容
 */
public class LiImpl extends AbsDom implements Li {

    /**
     * 子元素（支持嵌套任意元素，如链接、图片、子列表等，如 <li><a>首页</a></li>）
     */
    private final List<Dom> children = new ArrayList<>();
    /**
     * 列表项文本内容
     */
    private String text;

    /**
     * 获取列表项文本内容
     */
    public String getText() {
        return text;
    }

    /**
     * 设置列表项文本内容
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * 获取节点名称（固定为 "li"，对应 HTML 标签名）
     */
    @Override
    public String getNodeType() {
        return "li";
    }

    /**
     * 添加子元素（支持嵌套链接、图片、子列表等，如 <li><span>项目</span><ul>...</ul></li>）
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
        sb.append("<li");
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
            sb.append("\n  ").append(child.toString().replace("\n", "\n  "));
        }
        sb.append("\n</li>");
        return prettyPrint(sb.toString());
    }

    @Override
    public void addElement(Dom element) {
        children.add(element);
    }

    @Override
    public boolean removeElement(Dom element) {
        return false;
    }

    @Override
    public List<Dom> getElements() {
        return children;
    }
}
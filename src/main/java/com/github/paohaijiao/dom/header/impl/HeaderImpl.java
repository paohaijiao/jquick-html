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
package com.github.paohaijiao.dom.header.impl;

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.dom.abs.AbsDom;
import com.github.paohaijiao.dom.header.Header;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 页头元素（<header>）的具体实现类
 * HTML 中 header 元素的特性，作为页面或区块的头部容器（如网站头部、文章头部）
 */
public class HeaderImpl extends AbsDom implements Header {

    /**
     * 存储头部内的子元素（如 Logo、标题、导航菜单、搜索框等）
     */
    private final List<Dom> children = new ArrayList<>();



    /**
     * 添加子元素到头部容器中
     * 例如：添加 Logo 图片（img）、网站标题（h1）、导航菜单（nav/ul）等
     */
    @Override
    public void addElement(Dom element) {
        if (element != null) {
            children.add(element);
        }
    }

    /**
     * 从头部容器中移除指定子元素
     */
    @Override
    public boolean removeElement(Dom element) {
        return children.remove(element);
    }

    /**
     * 获取头部容器中所有子元素（返回不可修改副本，避免外部直接修改内部集合）
     */
    @Override
    public List<Dom> getElements() {
        return Collections.unmodifiableList(new ArrayList<>(children));
    }

    /**
     * 获取节点名称（固定为 "header"，对应 HTML 标签名）
     */
    @Override
    public String getNodeType() {
        return "header";
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



    /**
     * 生成 HTML 标签的字符串，包含所有属性和子元素
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<header");
        if(null!=attributes && !attributes.isEmpty()) {
            sb.append(" ").append(toAttrString());
        }
        if(null!=style && !style.isEmpty()) {
            sb.append(" ").append(toStyleString());
        }
        sb.append(">");
        for (Dom child : children) {
            sb.append("\n  ").append(child.toString().replace("\n", "\n  "));
        }
        sb.append("\n</header>");
        return prettyPrint(sb.toString());
    }
}
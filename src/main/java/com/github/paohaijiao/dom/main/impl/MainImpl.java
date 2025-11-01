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
import com.github.paohaijiao.dom.abs.AbsDom;
import com.github.paohaijiao.dom.main.Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 主要内容区域（<main>）的具体实现类
 * HTML 中 main 元素的特性，用于承载页面的核心内容（一个页面通常只应有一个 main 元素）
 */
public class MainImpl extends AbsDom implements Main {

    /**
     * 存储主要内容区域内的子元素（如文章、表单、列表、区块等核心内容）
     */
    private final List<Dom> children = new ArrayList<>();




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


    /**
     * 生成 HTML 标签的字符串，包含所有属性和子元素
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<main");
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
        sb.append("\n</main>");
        return prettyPrint(sb.toString());
    }
}

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
package com.github.paohaijiao.dom.div.impl;

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.dom.abs.AbsDom;
import com.github.paohaijiao.dom.div.Div;
import com.github.paohaijiao.enums.DomEnums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 通用块级容器（<div>）的具体实现类
 * HTML 中 div 元素的通用容器特性，用于页面布局和内容分组
 */
public class DivImpl extends AbsDom implements Div {
    /**
     * 存储子元素（可包含任何 Node 类型，如 p、span、button、其他 div 等）
     */
    private final List<Dom> children = new ArrayList<>();
    /**
     * 获取节点名称（固定为 "div"，对应 HTML 标签名）
     */
    @Override
    public String getNodeType() {
        return DomEnums.div.getCode();
    }


    @Override
    public void addElement(Dom element) {
        if (element != null) {
            children.add(element);
        }
    }

    /**
     * 从 div 中移除指定子元素
     */
    @Override
    public boolean removeElement(Dom element) {
        return children.remove(element);
    }

    /**
     * 获取所有子元素（返回不可修改副本，避免外部直接修改内部集合）
     */
    @Override
    public List<Dom> getElements() {
        return Collections.unmodifiableList(new ArrayList<>(children));
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
        sb.append("<div");
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
        sb.append("</div>");
        return prettyPrint(sb.toString());
    }
}

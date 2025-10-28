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
package com.github.paohaijiao.node.ol.impl;

import com.github.paohaijiao.common.Node;
import com.github.paohaijiao.enums.HtmlElementEnums;
import com.github.paohaijiao.node.li.Li;
import com.github.paohaijiao.node.ol.Ol;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName com.github.paohaijiao.node.ul.impl
 *
 * @author Martin
 * @version 1.0.0
 * @since 2025/10/28
 */
public class OlImpl implements Ol {

    private final List<Node> children = new ArrayList<>();

    private String listStyle;

    @Override
    public String getNodeName() {
        return HtmlElementEnums.ul.getCode();
    }

    @Override
    public String getListStyle() {
        return listStyle;
    }

    @Override
    public void setListStyle(String style) {
        this.listStyle = style;
    }

    @Override
    public void addElement(Node element) {
        if (element instanceof Li) {
            children.add(element);
        } else {
            throw new IllegalArgumentException("Ol can only contain Li elements");
        }
    }

    @Override
    public boolean removeElement(Node element) {
        return children.remove(element);
    }

    @Override
    public List<Node> getElements() {
        return new ArrayList<>(children);
    }

    @Override
    public void addChild(Node child) {
        addElement(child);
    }

    @Override
    public List<Node> getChildren() {
        return getElements();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(getNodeName());
        if (listStyle != null && !listStyle.isEmpty()) {
            sb.append(" style=\"list-style-type: ").append(listStyle).append(";\"");
        }
        sb.append(">");
        for (Node child : children) {
            sb.append(child.toString());
        }
        sb.append("</").append(getNodeName()).append(">");
        return sb.toString();
    }
}

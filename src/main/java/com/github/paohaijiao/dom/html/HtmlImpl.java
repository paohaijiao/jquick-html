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
package com.github.paohaijiao.dom.html;


import com.github.paohaijiao.model.AttrModel;
import com.github.paohaijiao.common.AttributeProvider;
import com.github.paohaijiao.common.Container;
import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.console.JConsole;
import com.github.paohaijiao.enums.JLogLevel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 通用HTML元素实现类，可用于div、p、h1-h6等普通元素
 */
public class HtmlImpl implements Container, AttributeProvider {

    private final String nodeType;

    private final List<Dom> children = new ArrayList<>();

    private AttrModel attributes;

    private final JConsole console = new JConsole();

    public HtmlImpl(String nodeType) {
        this.nodeType = nodeType;
    }

    @Override
    public void addElement(Dom element) {
        if (element != null) {
            children.add(element);
            console.log(JLogLevel.DEBUG, "Added child element to <" + nodeType + ">");
        }
    }

    @Override
    public boolean removeElement(Dom element) {
        boolean removed = children.remove(element);
        if (removed) {
            console.log(JLogLevel.DEBUG, "Removed child element from <" + nodeType + ">");
        }
        return removed;
    }

    @Override
    public List<Dom> getElements() {
        return Collections.unmodifiableList(new ArrayList<>(children));
    }

    @Override
    public String getNodeType() {
        return nodeType;
    }

    @Override
    public void addChild(Dom child) {
        addElement(child);
    }

    @Override
    public List<Dom> getChildren() {
        return getElements();
    }

    @Override
    public AttrModel getAttribute() {
        return attributes;
    }

    @Override
    public void setAttribute(AttrModel attribute) {
        this.attributes = attribute;
        console.log(JLogLevel.DEBUG, "Set attributes for <" + nodeType + ">");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(nodeType);
        if (attributes != null) {
            sb.append(" ").append(attributes);
        }
        if (children.isEmpty()) {
            sb.append("/>");
        } else {
            sb.append(">");
            for (Dom child : children) {
                sb.append("\n  ").append(child.toString().replace("\n", "\n  "));
            }
            sb.append("\n</").append(nodeType).append(">");
        }
        return sb.toString();
    }
}
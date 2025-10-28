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
package com.github.paohaijiao.node.thead.impl;

import com.github.paohaijiao.common.Node;
import com.github.paohaijiao.node.thead.Thead;
import com.github.paohaijiao.node.tr.Tr;

import java.util.ArrayList;
import java.util.List;

public class TheadImpl implements Thead {
    private final List<Node> children = new ArrayList<>();

    @Override
    public void addElement(Node element) {
        if (element instanceof Tr) {
            children.add(element);
        } else {
            throw new IllegalArgumentException("Thead can only contain Tr elements");
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
        sb.append("<").append(getNodeName()).append(">");
        for (Node child : children) {
            sb.append(child.toString());
        }
        sb.append("</").append(getNodeName()).append(">");
        return sb.toString();
    }
}

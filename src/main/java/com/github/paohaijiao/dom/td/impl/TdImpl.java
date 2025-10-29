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
package com.github.paohaijiao.dom.td.impl;

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.dom.td.Td;

import java.util.ArrayList;
import java.util.List;

public class TdImpl implements Td {

    private final List<Dom> children = new ArrayList<>();
    private int colSpan = 1;

    @Override
    public int getColSpan() {
        return colSpan;
    }

    @Override
    public void setColSpan(int span) {
        if (span < 1) {
            throw new IllegalArgumentException("Colspan must be at least 1");
        }
        this.colSpan = span;
    }

    @Override
    public void addElement(Dom element) {
        children.add(element);
    }

    @Override
    public boolean removeElement(Dom element) {
        return children.remove(element);
    }

    @Override
    public List<Dom> getElements() {
        return new ArrayList<>(children);
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
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(getNodeType());
        if (colSpan > 1) {
            sb.append(" colspan=\"").append(colSpan).append("\"");
        }
        sb.append(">");
        for (Dom child : children) {
            sb.append(child.toString());
        }
        sb.append("</").append(getNodeType()).append(">");
        return sb.toString();
    }
}

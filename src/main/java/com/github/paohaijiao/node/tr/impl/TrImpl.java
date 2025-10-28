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
package com.github.paohaijiao.node.tr.impl;

import com.github.paohaijiao.common.Node;
import com.github.paohaijiao.node.td.Td;
import com.github.paohaijiao.node.tr.Tr;

import java.util.ArrayList;
import java.util.List;

public class TrImpl implements Tr {
    private final List<Node> cells = new ArrayList<>();
    private final List<Node> children = new ArrayList<>();

    @Override
    public void addCell(Node cell) {
        if (cell instanceof Td) {
            cells.add(cell);
            children.add(cell);
        } else {
            throw new IllegalArgumentException("Tr can only contain Td or Th elements");
        }
    }

    @Override
    public void addElement(Node element) {
        addCell(element);
    }

    @Override
    public boolean removeElement(Node element) {
        boolean removedFromCells = cells.remove(element);
        boolean removedFromChildren = children.remove(element);
        return removedFromCells && removedFromChildren;
    }

    @Override
    public List<Node> getElements() {
        return new ArrayList<>(children);
    }

    @Override
    public void addChild(Node child) {
        addCell(child);
    }

    @Override
    public List<Node> getChildren() {
        return getElements();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(getNodeName()).append(">");
        for (Node cell : cells) {
            sb.append(cell.toString());
        }
        sb.append("</").append(getNodeName()).append(">");
        return sb.toString();
    }
}

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
package com.github.paohaijiao.dom.table.impl;

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.dom.abs.AbsDom;
import com.github.paohaijiao.enums.DomEnums;
import com.github.paohaijiao.dom.table.Table;
import com.github.paohaijiao.dom.thead.Thead;
import com.github.paohaijiao.dom.tr.Tr;

import java.util.ArrayList;
import java.util.List;

public class TableImpl extends AbsDom implements Table {
    private final List<Tr> rows = new ArrayList<>();
    private final List<Dom> children = new ArrayList<>();
    private int borderWidth;
    private Thead thead;

    @Override
    public String getNodeType() {
        return DomEnums.table.getCode();
    }

    @Override
    public void setBorder(int borderWidth) {
        this.borderWidth = borderWidth;
    }

    @Override
    public int getBorderWidth() {
        return borderWidth;
    }

    @Override
    public Thead getThead() {
        return thead;
    }

    @Override
    public void setThead(Thead thead) {
        if (this.thead != null) {
            children.remove(this.thead);
        }
        this.thead = thead;
        if (thead != null) {
            children.add(thead);
        }
    }

    @Override
    public void addRow(Tr row) {
        rows.add(row);
        children.add(row);
    }

    @Override
    public List<Tr> getRows() {
        return new ArrayList<>(rows);
    }

    @Override
    public void addElement(Dom element) {
        if (element instanceof Thead) {
            setThead((Thead) element);
        } else if (element instanceof Tr) {
            addRow((Tr) element);
        } else {
            throw new IllegalArgumentException("Table can only contain Thead or Tr elements");
        }
    }

    @Override
    public boolean removeElement(Dom element) {
        if (element instanceof Thead && element.equals(thead)) {
            thead = null;
            return children.remove(element);
        } else if (element instanceof Tr) {
            boolean removedFromRows = rows.remove(element);
            boolean removedFromChildren = children.remove(element);
            return removedFromRows && removedFromChildren;
        }
        return false;
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
        if (borderWidth > 0) {
            sb.append(" border=\"").append(borderWidth).append("\"");
        }
        sb.append(">");
        if (thead != null) {
            sb.append(thead);
        }
        for (Tr row : rows) {
            sb.append(row.toString());
        }
        sb.append("</").append(getNodeType()).append(">");
        return prettyPrint(sb.toString());
    }
}
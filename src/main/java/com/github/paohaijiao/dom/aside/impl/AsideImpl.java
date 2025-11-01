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
package com.github.paohaijiao.dom.aside.impl;

import com.github.paohaijiao.common.Container;
import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.dom.abs.AbsDom;
import com.github.paohaijiao.enums.DomEnums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * packageName com.github.paohaijiao.node.aside.impl
 *
 * @author Martin
 * @version 1.0.0
 * @since 2025/10/28
 */
public class AsideImpl extends AbsDom implements Container {

    private final List<Dom> children = new ArrayList<>();

    @Override
    public void addElement(Dom element) {
        if (element != null) {
            children.add(element);
        }
    }


    @Override
    public boolean removeElement(Dom element) {
        return children.remove(element);
    }


    @Override
    public List<Dom> getElements() {
        return Collections.unmodifiableList(new ArrayList<>(children));
    }


    @Override
    public String getNodeType() {
        return DomEnums.aside.getCode();
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
        sb.append("<aside");
        if (attributes != null&&!attributes.isEmpty()) {
            sb.append(" ").append(toAttrString());
        }
        sb.append(">");
        for (Dom child : children) {
            sb.append("\n  ").append(child.toString().replace("\n", "\n  "));
        }
        sb.append("\n</aside>");
        return prettyPrint(sb.toString());
    }
}

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
package com.github.paohaijiao.dom.a.impl;

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.dom.a.A;
import com.github.paohaijiao.dom.abs.AbsDom;
import com.github.paohaijiao.enums.DomEnums;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AImpl extends AbsDom implements A {

    private final List<Dom> children = new ArrayList<>();


    private String text;

    private String target;

    public String getNodeType() {
        return DomEnums.a.getCode();
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getTarget() {
        return target;
    }

    @Override
    public void setTarget(String target) {
        this.target = target;
    }

    @Override
    public void addChild(Dom child) {
        children.add(child);
    }

    @Override
    public List<Dom> getChildren() {
        return new ArrayList<>(children);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<a");
        if (target != null && !target.isEmpty()) {
            sb.append(" target=\"").append(target).append("\"");
        }
        if (attributes != null&&!attributes.isEmpty()) {
            sb.append(" ").append(toAttrString());
        }
        sb.append(">");
        if (text != null && !text.isEmpty()) {
            sb.append(text);
        }
        if (!children.isEmpty()) {
            String childrenHtml = children.stream()
                    .map(Dom::toString)
                    .collect(Collectors.joining());
            sb.append(childrenHtml);
        }

        sb.append("</a>");
        return prettyPrint(sb.toString());
    }
}

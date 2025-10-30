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
package com.github.paohaijiao.layout.impl;

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.layout.Layout;
import com.github.paohaijiao.layout.params.LayoutParams;

import java.util.ArrayList;
import java.util.List;

/**
 * 流式布局：子元素按水平方向排列，超出容器宽度后自动换行
 */
public class FlowLayout implements Layout {

    private final List<LayoutChild> children = new ArrayList<>();
    /**
     * 布局自身参数（如间距）
     */
    private LayoutParams layoutParams = new LayoutParams();

    @Override
    public String getLayoutType() {
        return "flow";
    }

    @Override
    public void addChild(Dom element, LayoutParams params) {
        if (element != null) {
            /**
             * 默认参数：若子元素无布局参数，设置默认间距
             */
            LayoutParams childParams = params != null ? params : new LayoutParams().add("margin", "5px");
            children.add(new LayoutChild(element, childParams));
        }
    }

    @Override
    public boolean removeChild(Dom element) {
        return children.removeIf(child -> child.getElement() == element);
    }

    @Override
    public List<LayoutChild> getChildren() {
        return new ArrayList<>(children);
    }

    @Override
    public LayoutParams getLayoutParams() {
        return layoutParams;
    }

    @Override
    public void setLayoutParams(LayoutParams params) {
        this.layoutParams = params != null ? params : new LayoutParams();
    }

    @Override
    public void layout(int containerWidth, int containerHeight) {
        /**
         * 计算子元素位置（实际实现需根据容器宽度和子元素尺寸计算换行）
         */
        int currentX = 0;
        int currentY = 0;
        int spacing = Integer.parseInt(layoutParams.getOrDefault("spacing", "5")); // 间距
        for (LayoutChild child : children) {
            /**
             * 假设子元素宽度从布局参数中获取（实际可能需要解析DOM元素的width）
             */
            int childWidth = Integer.parseInt(child.getParams().getOrDefault("width", "100"));
            int childHeight = Integer.parseInt(child.getParams().getOrDefault("height", "50"));
            /**
             * 假设子元素宽度从布局参数中获取（实际可能需要解析DOM元素的width）
             */
            if (currentX + childWidth > containerWidth) {
                currentX = 0;
                currentY += childHeight + spacing;
            }

            /**
             *  设置子元素的位置（通过style的position实现）
             */
            child.getParams().add("position", "absolute").add("left", currentX + "px").add("top", currentY + "px");
            currentX += childWidth + spacing;
        }
    }

    @Override
    public String toHtml() {
        StringBuilder html = new StringBuilder();
        /**
         * 容器样式：相对定位
         */
        html.append("<div style=\"position: relative; ").append(layoutParams.toStyle()).append("\">");
        /**
         * 子元素HTML
         */
        for (LayoutChild child : children) {
            Dom element = child.getElement();
            /**
             * 为子元素添加布局计算后的样式
             */
            //element.setAttribute(child.getParams().toAttrModel());
            html.append("\n  ").append(element.toString().replace("\n", "\n  "));
        }
        html.append("\n</div>");
        return html.toString();
    }
}

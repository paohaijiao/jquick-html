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
 * 弹性布局：通过弹性容器控制子元素的排列、对齐和分布
 */
public class FlexLayout implements Layout {

    private final List<LayoutChild> children = new ArrayList<>();
    /**
     * 布局参数（flex-direction, justify-content）
     */
    private LayoutParams layoutParams;

    /**
     * 默认水平方向、居中对齐
     */
    public FlexLayout() {
        this.layoutParams = new LayoutParams()
                .add("display", "flex")
                .add("flex-direction", "row")
                .add("justify-content", "center")
                .add("gap", "8px");
    }

    @Override
    public String getLayoutType() {
        return "flex";
    }

    /**
     * 子元素可指定弹性权重（如flex: 1）
     *
     * @param element 子元素
     * @param params  该元素在布局中的参数（如网格中的行/列位置、弹性布局中的权重等）
     */
    @Override
    public void addChild(Dom element, LayoutParams params) {
        if (element != null) {
            LayoutParams childParams = params != null ? params : new LayoutParams()
                    .add("flex", "0"); // 默认不伸缩
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
        if (params != null) {
            params.add("display", "flex"); // 确保弹性布局标识
            this.layoutParams = params;
        }
    }

    /**
     * 响应式调整方向：窄容器下改为垂直排列
     *
     * @param containerWidth  容器宽度
     * @param containerHeight 容器高度
     */
    @Override
    public void layout(int containerWidth, int containerHeight) {
        if (containerWidth < 500) {
            layoutParams.add("flex-direction", "column");
        } else {
            layoutParams.add("flex-direction", "row");
        }
    }

    @Override
    public String toHtml() {
        StringBuilder html = new StringBuilder();
        html.append("<div style=\"").append(layoutParams.toStyle()).append("\">");// 弹性容器
        for (LayoutChild child : children) {// 子元素（应用弹性参数）
            Dom element = child.getElement();
            // element.setAttribute(child.getParams().toAttrModel());
            html.append("\n  ").append(element.toString().replace("\n", "\n  "));
        }

        html.append("\n</div>");
        return html.toString();
    }
}

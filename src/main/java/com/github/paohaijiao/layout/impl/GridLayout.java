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
 * 网格布局：按行列划分区域，子元素可指定行/列位置及跨度
 */
public class GridLayout implements Layout {

    private final List<LayoutChild> children = new ArrayList<>();
    /**
     * 布局参数（如columns: "1fr 1fr 1fr"）
     */
    private LayoutParams layoutParams;

    /**
     * 默认3列网格
     */
    public GridLayout() {
        this.layoutParams = new LayoutParams()
                .add("display", "grid")
                .add("grid-template-columns", "1fr 1fr 1fr")
                .add("gap", "10px");
    }

    @Override
    public String getLayoutType() {
        return "grid";
    }

    /**
     * 子元素必须指定网格位置（如grid-column: 1 / 3; grid-row: 1）
     *
     * @param element 子元素
     * @param params  该元素在布局中的参数（如网格中的行/列位置、弹性布局中的权重等）
     */
    @Override
    public void addChild(Dom element, LayoutParams params) {
        if (element != null) {
            LayoutParams childParams = params != null ? params : new LayoutParams()
                    .add("grid-column", "1")
                    .add("grid-row", "1");
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

    /**
     * 确保网格布局的核心属性存在
     *
     * @param params
     */
    @Override
    public void setLayoutParams(LayoutParams params) {
        if (params != null) {

            params.add("display", "grid");
            this.layoutParams = params;
        }
    }

    /**
     * 网格布局的计算由CSS自动处理，此处可根据容器尺寸动态调整列数
     *
     * @param containerWidth  容器宽度
     * @param containerHeight 容器高度
     */
    @Override
    public void layout(int containerWidth, int containerHeight) {
        String columns = layoutParams.get("grid-template-columns");
        if (containerWidth < 600 && columns.contains("1fr 1fr 1fr")) {
            // 小屏幕下改为2列
            layoutParams.add("grid-template-columns", "1fr 1fr");
        }
    }

    @Override
    public String toHtml() {
        StringBuilder html = new StringBuilder();
        html.append("<div style=\"").append(layoutParams.toStyle()).append("\">");// 网格容器
        for (LayoutChild child : children) { // 子元素（应用网格位置样式）
            Dom element = child.getElement();
            // element.setAttribute(child.getParams().toAttrModel());
            html.append("\n  ").append(element.toString().replace("\n", "\n  "));
        }

        html.append("\n</div>");
        return html.toString();
    }
}

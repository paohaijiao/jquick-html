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
package com.github.paohaijiao.dom.button.impl;

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.dom.abs.AbsDom;
import com.github.paohaijiao.dom.button.Button;
import com.github.paohaijiao.enums.DomEnums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * packageName com.github.paohaijiao.node.button.impl
 * 按钮类型（如 submit/reset/button，默认 button）
 * @author Martin
 * @version 1.0.0
 * @since 2025/10/28
 */
public class ButtonImpl extends AbsDom implements Button {

    /**
     * 子元素（支持嵌套图标等，如 <button><i>图标</i>文本</button>）
     */
    private final List<Dom> children = new ArrayList<>();
    /**
     * 按钮显示文本
     */
    private String text;
    /**
     * 点击事件处理器
     */
    private String onClick;
    /**
     * 按钮是否禁用
     */
    private boolean disabled;



    /**
     * 获取按钮显示文本
     */
    @Override
    public String getText() {
        return text;
    }

    /**
     * 设置按钮显示文本
     */
    @Override
    public void setText(String text) {
        this.text = text;
    }

    /**
     * 获取点击事件处理器
     */
    @Override
    public String getOnClick() {
        return onClick;
    }

    /**
     * 设置点击事件处理器（如 "handleSubmit()"）
     */
    @Override
    public void setOnClick(String handler) {
        this.onClick = handler;
    }

    /**
     * 判断按钮是否禁用
     */
    @Override
    public boolean isDisabled() {
        return disabled;
    }

    /**
     * 设置按钮是否禁用
     */
    @Override
    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    /**
     * 获取节点名称（固定为 "button"）
     */
    @Override
    public String getNodeType() {
        return DomEnums.button.getCode();
    }

    /**
     * 添加子元素（如图标 <i>、span 等）
     */
    @Override
    public void addChild(Dom child) {
        if (child != null) {
            children.add(child);
        }
    }


    /**
     * 获取所有子元素（不可修改列表）
     */
    @Override
    public List<Dom> getChildren() {
        return Collections.unmodifiableList(new ArrayList<>(children));
    }
    /**
     * 生成 HTML 标签的字符串
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<button");
        if (onClick != null && !onClick.isEmpty()) {
            sb.append(" onclick=\"").append(onClick).append("\"");
        }
        if(null!=attributes && !attributes.isEmpty()) {
            sb.append(" ").append(toAttrString());
        }
        if (disabled) {
            sb.append(" disabled");
        }
        sb.append(">");
        if (text != null && !text.isEmpty()) {
            sb.append(text);
        }
        for (Dom child : children) {
            sb.append(child.toString());
        }
        sb.append("</button>");
        return prettyPrint(sb.toString());
    }
}

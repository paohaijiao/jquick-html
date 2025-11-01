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
package com.github.paohaijiao.dom.img.impl;

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.dom.abs.AbsDom;
import com.github.paohaijiao.dom.img.Img;
import com.github.paohaijiao.enums.DomEnums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 图像元素（<img>）的具体实现类
 * HTML 中 img 元素的特性，用于加载和展示图像资源
 */
public class ImgImpl extends AbsDom implements Img {

    /**
     * 子元素（img 是自闭合标签，理论上无内容，此处预留但实际不使用）
     */
    private final List<Dom> children = new ArrayList<>();
    /**
     * 图像资源路径（核心属性，指向图片的 URL 或本地路径）
     */
    private static String src="src";
    /**
     * 替代文本（当图片加载失败或屏幕阅读器访问时显示）
     */
    private String alt="alt";

    /**
     * 图像点击事件处理器（如点击图片跳转或放大）
     */
    private String onClick;

    /**
     * 获取图像资源路径
     */
    public String getSrc() {
        return this.attributes.get(src);
    }



    /**
     * 获取替代文本
     */
    public String getAlt() {
        return this.attributes.get(alt);
    }



    /**
     * 获取节点名称（固定为 "img"，对应 HTML 标签名）
     */
    @Override
    public String getNodeType() {
        return DomEnums.img.getCode();
    }

    /**
     * 添加子元素（img 是自闭合标签，此方法实际无效，仅为实现接口）
     */
    @Override
    public void addChild(Dom child) {
        // img 标签不支持子元素
    }

    /**
     * 获取子元素（返回空列表，img 无内容）
     */
    @Override
    public List<Dom> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public String getOnClick() {
        return onClick;
    }

    /**
     * 设置点击事件处理器（如 "openImagePreview()"）
     * 用于实现点击图片放大、跳转等交互功能
     */
    public void setOnClick(String handler) {
        this.onClick = handler;
    }


    /**
     * 生成 HTML 标签的字符串（自闭合标签格式）
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<img");
        if(null!=attributes && !attributes.isEmpty()) {
            sb.append(" ").append(toAttrString());
        }
        if(null!=style && !style.isEmpty()) {
            sb.append(" ").append(toStyleString());
        }
        if (onClick != null && !onClick.isEmpty()) {
            sb.append(" onclick=\"").append(onClick).append("\"");
        }
        sb.append("/>");
        return prettyPrint(sb.toString());
    }
}

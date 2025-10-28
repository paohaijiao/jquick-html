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
package com.github.paohaijiao.node.img.impl;

import com.github.paohaijiao.common.Node;
import com.github.paohaijiao.node.img.Img;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 图像元素（<img>）的具体实现类
 * HTML 中 img 元素的特性，用于加载和展示图像资源
 */
public class ImgImpl implements Img {

    /**
     * 子元素（img 是自闭合标签，理论上无内容，此处预留但实际不使用）
     */
    private final List<Node> children = new ArrayList<>();
    /**
     * 图像资源路径（核心属性，指向图片的 URL 或本地路径）
     */
    private String src;
    /**
     * 替代文本（当图片加载失败或屏幕阅读器访问时显示）
     */
    private String alt;
    /**
     * 图像宽度（支持像素值或百分比，如 "200px"、"50%"）
     */
    private int width;
    /**
     * 图像高度（支持像素值或百分比）
     */
    private int height;
    /**
     * 通用属性：CSS 类名（用于样式控制，如边框、圆角、阴影等）
     */
    private String className;
    /**
     * 通用属性：唯一标识（用于脚本操作或样式锚点）
     */
    private String id;
    /**
     * 图像加载失败时的备用路径
     */
    private String onErrorSrc;
    /**
     * 图像点击事件处理器（如点击图片跳转或放大）
     */
    private String onClick;

    /**
     * 获取图像资源路径
     */
    @Override
    public String getSrc() {
        return src;
    }

    /**
     * 设置图像资源路径（src 属性，必填）
     */
    @Override
    public void setSrc(String url) {
        this.src = url;
    }

    /**
     * 获取替代文本
     */
    @Override
    public String getAlt() {
        return alt;
    }

    /**
     * 设置替代文本（alt 属性，推荐必填，提升可访问性）
     */
    @Override
    public void setAlt(String altText) {
        this.alt = altText;
    }

    /**
     * 获取图像宽度
     */
    @Override
    public int getWidth() {
        return width;
    }

    /**
     * 设置图像宽度（像素值）
     */
    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * 获取图像高度
     */
    @Override
    public int getHeight() {
        return height;
    }

    /**
     * 设置图像高度（像素值）
     */
    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * 获取节点名称（固定为 "img"，对应 HTML 标签名）
     */
    @Override
    public String getNodeName() {
        return "img";
    }

    /**
     * 添加子元素（img 是自闭合标签，此方法实际无效，仅为实现接口）
     */
    @Override
    public void addChild(Node child) {
        // img 标签不支持子元素
    }

    /**
     * 获取子元素（返回空列表，img 无内容）
     */
    @Override
    public List<Node> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public String getClassName() {
        return className;
    }

    /**
     * 设置 CSS 类名（如 "rounded"、"bordered"、"responsive-img"）
     * 用于控制图片样式（圆角、边框、响应式缩放等）
     */
    public void setClassName(String className) {
        this.className = className;
    }

    public String getId() {
        return id;
    }

    /**
     * 设置唯一标识（用于脚本操作，如通过 JS 动态更换图片）
     */
    public void setId(String id) {
        this.id = id;
    }

    public String getOnErrorSrc() {
        return onErrorSrc;
    }

    /**
     * 设置加载失败时的备用图片路径（通过 onerror 事件触发）
     * 例如：当 src 路径无效时，自动加载此路径的图片
     */
    public void setOnErrorSrc(String onErrorSrc) {
        this.onErrorSrc = onErrorSrc;
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
        if (src != null && !src.isEmpty()) {
            sb.append(" src=\"").append(src).append("\"");
        } else {
            sb.append(" src=\"\""); // 即使为空也保留属性，符合 HTML 规范
        }
        if (alt != null && !alt.isEmpty()) {
            sb.append(" alt=\"").append(alt).append("\"");
        }
        if (width > 0) {
            sb.append(" width=\"").append(width).append("\"");
        }
        if (height > 0) {
            sb.append(" height=\"").append(height).append("\"");
        }

        if (id != null && !id.isEmpty()) {
            sb.append(" id=\"").append(id).append("\"");
        }
        if (className != null && !className.isEmpty()) {
            sb.append(" class=\"").append(className).append("\"");
        }
        if (onClick != null && !onClick.isEmpty()) {
            sb.append(" onclick=\"").append(onClick).append("\"");
        }
        if (onErrorSrc != null && !onErrorSrc.isEmpty()) {
            sb.append(" onerror=\"this.src='").append(onErrorSrc).append("'\"");
        }
        sb.append("/>");
        return sb.toString();
    }
}

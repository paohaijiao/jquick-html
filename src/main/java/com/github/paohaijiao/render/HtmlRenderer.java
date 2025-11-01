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
package com.github.paohaijiao.render;

import com.github.paohaijiao.common.AttributeProvider;
import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.model.AttrModel;
import com.github.paohaijiao.provider.DomProvider;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 复杂HTML渲染器，支持完整DOM树渲染、属性处理、事件绑定和样式应用
 */
public class HtmlRenderer {

    private static final Set<String> SELF_CLOSING_TAGS = Collections.unmodifiableSet(new HashSet<String>(Arrays.asList(
            "area", "base", "br", "col", "embed", "hr", "img", "input",
            "link", "meta", "param", "source", "track", "wbr"
    )));

    // 缩进空格数（用于格式化输出）
    private static final int INDENT_SPACES = 2;

    /**
     * 将DOM树渲染为HTML字符串
     * @param root 根DOM元素
     * @return HTML字符串
     */
    public String render(Dom root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        renderElement(root, sb, 0);
        return sb.toString();
    }

    /**
     * 将DOM树渲染为完整的HTML文档
     * @param doctype 文档声明（如"<!DOCTYPE html>"）
     * @param root 根DOM元素（通常是<html>标签）
     * @return 完整的HTML文档字符串
     */
    public String renderToHtmlDocument(String doctype, Dom root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (doctype != null && !doctype.trim().isEmpty()) {
            sb.append(doctype).append("\n");
        }

        renderElement(root, sb, 0);

        return sb.toString();
    }

    /**
     * 递归渲染单个DOM元素
     * @param element 当前DOM元素
     * @param sb StringBuilder用于构建HTML
     * @param depth 当前深度（用于缩进）
     */
    private void renderElement(Dom element, StringBuilder sb, int depth) {
        if (element == null) {
            return;
        }

        // 获取元素类型（标签名）
        String nodeType = getNodeType(element);
        if (nodeType == null || nodeType.isEmpty()) {
            return;
        }

        // 添加缩进
        addIndent(sb, depth);

        // 开始标签
        sb.append("<").append(nodeType);

        // 渲染属性
        renderAttributes(element, sb);

        // 渲染事件处理器
        renderEventHandlers(element, sb);

        // 渲染样式
        renderStyles(element, sb);

        // 检查是否为自闭合标签
        if (isSelfClosingTag(nodeType)) {
            sb.append("/>");
            sb.append("\n");
            return;
        }

        // 闭合开始标签
        sb.append(">");

        // 获取元素内容
        String content = getElementContent(element);

        // 获取子元素
        List<Dom> children = element.getChildren();

        // 渲染内容和子元素
        if (children != null && !children.isEmpty()) {
            sb.append("\n");

            // 如果有内容，先渲染内容
            if (content != null && !content.isEmpty()) {
                addIndent(sb, depth + 1);
                sb.append(escapeHtml(content)).append("\n");
            }

            // 递归渲染子元素
            for (Dom child : children) {
                renderElement(child, sb, depth + 1);
            }

            // 添加缩进并闭合标签
            addIndent(sb, depth);
            sb.append("</").append(nodeType).append(">");
        } else {
            // 没有子元素，直接在同一行闭合标签
            if (content != null && !content.isEmpty()) {
                sb.append(escapeHtml(content));
            }
            sb.append("</").append(nodeType).append(">");
        }

        sb.append("\n");
    }

    /**
     * 渲染元素属性
     */
    private void renderAttributes(Dom element, StringBuilder sb) {
        if (element instanceof AttributeProvider) {
            AttrModel attributes = ((AttributeProvider) element).getAttribute();
            if (attributes != null) {
                Map<String, String> attrMap = attributes.getMap();
                if (attrMap != null && !attrMap.isEmpty()) {
                    for (Map.Entry<String, String> entry : attrMap.entrySet()) {
                        String key = entry.getKey();
                        String value = entry.getValue();
                        if (key != null && value != null) {
                            sb.append(" ").append(key).append("=\"").append(escapeHtmlAttribute(value)).append("\"");
                        }
                    }
                }
            }
        }
    }

    /**
     * 渲染事件处理器
     */
    private void renderEventHandlers(Dom element, StringBuilder sb) {
        // 如果元素实现了事件相关接口，渲染事件属性
        if (element instanceof EventProvider) {
            EventProvider eventProvider = (EventProvider) element;
            Map<String, String> eventHandlers = eventProvider.getEventHandlers();
            if (eventHandlers != null && !eventHandlers.isEmpty()) {
                for (Map.Entry<String, String> entry : eventHandlers.entrySet()) {
                    String eventType = entry.getKey();
                    String handler = entry.getValue();
                    if (eventType != null && handler != null) {
                        sb.append(" on").append(eventType.toLowerCase())
                                .append("=\"").append(escapeJavaScript(handler)).append("\"");
                    }
                }
            }
        }
    }

    /**
     * 渲染样式
     */
    private void renderStyles(Dom element, StringBuilder sb) {
        // 如果元素实现了样式相关接口，渲染style属性
        if (element instanceof StyleProvider) {
            StyleProvider styleProvider = (StyleProvider) element;
            Map<String, String> styles = styleProvider.getStyles();
            if (styles != null && !styles.isEmpty()) {
                String styleContent = styles.entrySet().stream()
                        .map(entry -> entry.getKey() + ":" + entry.getValue())
                        .collect(Collectors.joining(";"));

                sb.append(" style=\"").append(escapeHtmlAttribute(styleContent)).append("\"");
            }
        }
    }

    /**
     * 获取元素类型（标签名）
     */
    private String getNodeType(Dom element) {
        if (element instanceof DomProvider) {
            return ((DomProvider) element).getNodeType();
        }
        return "div"; // 默认div标签
    }

    /**
     * 获取元素内容
     */
    private String getElementContent(Dom element) {
        if (element instanceof ContentProvider) {
            return ((ContentProvider) element).getContent();
        }
        return null;
    }

    /**
     * 检查是否为自闭合标签
     */
    private boolean isSelfClosingTag(String tagName) {
        return SELF_CLOSING_TAGS.contains(tagName.toLowerCase());
    }

    /**
     * 添加缩进
     */
    private void addIndent(StringBuilder sb, int depth) {
        for (int i = 0; i < depth * INDENT_SPACES; i++) {
            sb.append(" ");
        }
    }

    /**
     * HTML特殊字符转义
     */
    private String escapeHtml(String content) {
        if (content == null) return "";

        return content.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }

    /**
     * HTML属性值转义
     */
    private String escapeHtmlAttribute(String value) {
        if (value == null) return "";

        return value.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;")
                .replace("\n", "&#10;")
                .replace("\r", "&#13;");
    }

    /**
     * JavaScript代码转义
     */
    private String escapeJavaScript(String code) {
        if (code == null) return "";

        return code.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("'", "\\'")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("<", "\\x3C")
                .replace(">", "\\x3E");
    }

    /**
     * 事件处理器接口（需要元素实现此接口才能支持事件渲染）
     */
    public interface EventProvider {
        Map<String, String> getEventHandlers();
    }

    /**
     * 样式提供者接口（需要元素实现此接口才能支持样式渲染）
     */
    public interface StyleProvider {
        Map<String, String> getStyles();
    }

    /**
     * 内容提供者接口（需要元素实现此接口才能支持文本内容渲染）
     */
    public interface ContentProvider {
        String getContent();
    }


}

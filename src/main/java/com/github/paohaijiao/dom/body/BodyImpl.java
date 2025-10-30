package com.github.paohaijiao.dom.body;

import com.github.paohaijiao.common.Body;
import com.github.paohaijiao.common.Container;
import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.model.AttrModel;
import com.github.paohaijiao.common.AttributeProvider;
import com.github.paohaijiao.console.JConsole;
import com.github.paohaijiao.enums.DomEnums;
import com.github.paohaijiao.enums.JLogLevel;

import java.util.*;

/**
 * Body接口实现类，对应HTML中的<body>元素
 */
public class BodyImpl implements Body, Container, AttributeProvider {

    private final List<Dom> children = new ArrayList<>();

    private AttrModel attributes=new AttrModel();

    private final JConsole console = new JConsole();

    private final Map<String, String> eventHandlers = new HashMap<>();

    @Override
    public void addElement(Dom element) {
        if (element != null) {
            children.add(element);
            console.log(JLogLevel.DEBUG, "Added child element to <body>");
        }
    }

    @Override
    public boolean removeElement(Dom element) {
        boolean removed = children.remove(element);
        if (removed) {
            console.log(JLogLevel.DEBUG, "Removed child element from <body>");
        }
        return removed;
    }

    @Override
    public List<Dom> getElements() {
        return Collections.unmodifiableList(new ArrayList<>(children));
    }

    @Override
    public String getNodeType() {
        return DomEnums.body.getCode();
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
    public AttrModel getAttribute() {
        return attributes;
    }

    @Override
    public void setAttribute(AttrModel attribute) {
        this.attributes = attribute;
        console.log(JLogLevel.DEBUG, "Set attributes for <body>");
    }

    // 新增方法实现
    @Override
    public void addContent(Dom content) {
        addElement(content);
        console.log(JLogLevel.DEBUG, "Added content to <body>");
    }

    @Override
    public List<Dom> getContents() {
        return Collections.unmodifiableList(new ArrayList<>(children));
    }

    @Override
    public void setBackgroundColor(String color) {
        if (attributes == null) {
            attributes = new AttrModel();
        }
        String existingStyle = attributes.get("style");
        if (existingStyle == null || existingStyle.isEmpty()) {
            attributes.put("style", "background-color: " + color + ";");
        } else {
            String newStyle = existingStyle.replaceAll("background-color:\\s*[^;]+;", "") + "background-color: " + color + ";";
            attributes.put("style", newStyle.trim());
        }
        console.log(JLogLevel.DEBUG, "Set body background color to: " + color);
    }

    @Override
    public String getBackgroundColor() {
        if (attributes == null) {
            return "";
        }
        String style = attributes.get("style");
        if (style == null || style.isEmpty()) {
            return "";
        }
        java.util.regex.Matcher matcher = java.util.regex.Pattern
                .compile("background-color:\\s*([^;]+)")
                .matcher(style);
        if (matcher.find()) {
            return matcher.group(1).trim();
        }
        return "";
    }

    @Override
    public void addEventHandler(String eventType, String handler) {
        // 存储事件处理器（如onclick、onload等）
        if (eventType != null && handler != null) {
            eventHandlers.put(eventType, handler);
            // 同时同步到属性中（事件属性如onclick）
            if (attributes == null) {
                attributes = new AttrModel();
            }
            attributes.put("on" + eventType.toLowerCase(), handler);
            console.log(JLogLevel.DEBUG, "Added event handler for: " + eventType);
        }
    }

    @Override
    public String getEventHandler(String eventType) {
        if (eventType == null) {
            return "";
        }
        return eventHandlers.getOrDefault(eventType, "");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<body");
        if (attributes != null&&!attributes.isEmpty()) {
            sb.append(" ").append(attributes.toString());
        }
        sb.append(">");
        for (Dom child : children) {
            sb.append("\n  ").append(child.toString().replace("\n", "\n  "));
        }
        sb.append("\n</body>");
        return sb.toString();
    }
}

package com.github.paohaijiao.node.label;

import com.github.paohaijiao.common.Node;
import com.github.paohaijiao.enums.HtmlElementEnums;

public interface Label extends Node {
    @Override
    default String getNodeName() {
        return HtmlElementEnums.label.getCode();
    }

    void setText(String text);
    String getText();

    void setFor(String elementId);

    String getFor();

}

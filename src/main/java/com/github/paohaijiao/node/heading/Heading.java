package com.github.paohaijiao.node.heading;

import com.github.paohaijiao.common.Node;
import com.github.paohaijiao.enums.HtmlElementEnums;

public interface Heading extends Node {
    @Override
    default String getNodeName() {
        return HtmlElementEnums.heading.getCode();
    }
    void setText(String text);

    String getText();

    int getLevel();
}

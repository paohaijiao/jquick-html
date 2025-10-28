package com.github.paohaijiao.node.p;

import com.github.paohaijiao.common.Node;
import com.github.paohaijiao.enums.HtmlElementEnums;

public interface P extends Node {
    @Override
    default String getNodeName() {
        return HtmlElementEnums.p.getCode();
    }

    void setText(String text);

    String getText();

    void setAlign(String align);

    String getAlign();
}

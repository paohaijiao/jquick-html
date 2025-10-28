package com.github.paohaijiao.node.i;

import com.github.paohaijiao.common.Node;
import com.github.paohaijiao.enums.HtmlElementEnums;

public interface I extends Node {
    @Override
    default String getNodeName() {
        return HtmlElementEnums.i.getCode();
    }

    void setText(String text);

    String getText();
}

package com.github.paohaijiao.node.span;

import com.github.paohaijiao.common.Node;
import com.github.paohaijiao.enums.HtmlElementEnums;

public interface Span extends Node {
    @Override
    default String getNodeName() {
        return HtmlElementEnums.span.getCode();
    }

    void setText(String text);

    String getText();

    void setStyle(String style);

    String getStyle();
}

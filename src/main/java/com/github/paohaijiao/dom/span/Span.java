package com.github.paohaijiao.dom.span;

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.enums.DomEnums;

public interface Span extends Dom {
    @Override
    default String getNodeType() {
        return DomEnums.span.getCode();
    }

    void setText(String text);

    String getText();

    void setStyle(String style);

    String getStyle();
}

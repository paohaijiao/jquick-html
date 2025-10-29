package com.github.paohaijiao.dom.span;

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.enums.HtmlElementEnums;

public interface Span extends Dom {
    @Override
    default String getNodeType() {
        return HtmlElementEnums.span.getCode();
    }

    void setText(String text);

    String getText();

    void setStyle(String style);

    String getStyle();
}

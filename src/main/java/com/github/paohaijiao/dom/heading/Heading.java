package com.github.paohaijiao.dom.heading;

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.enums.HtmlElementEnums;

public interface Heading extends Dom {
    @Override
    default String getNodeType() {
        return HtmlElementEnums.heading.getCode();
    }
    void setText(String text);

    String getText();

    int getLevel();
}

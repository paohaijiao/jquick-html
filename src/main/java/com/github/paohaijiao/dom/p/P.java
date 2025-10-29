package com.github.paohaijiao.dom.p;

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.enums.HtmlElementEnums;

public interface P extends Dom {
    @Override
    default String getNodeType() {
        return HtmlElementEnums.p.getCode();
    }

    void setText(String text);

    String getText();

    void setAlign(String align);

    String getAlign();
}

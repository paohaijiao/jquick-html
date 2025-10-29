package com.github.paohaijiao.dom.i;

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.enums.HtmlElementEnums;

public interface I extends Dom {
    @Override
    default String getNodeType() {
        return HtmlElementEnums.i.getCode();
    }

    void setText(String text);

    String getText();
}

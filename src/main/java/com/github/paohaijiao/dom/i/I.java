package com.github.paohaijiao.dom.i;

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.enums.DomEnums;

public interface I extends Dom {
    @Override
    default String getNodeType() {
        return DomEnums.i.getCode();
    }

    void setText(String text);

    String getText();
}

package com.github.paohaijiao.dom.label;

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.enums.DomEnums;

public interface Label extends Dom {
    @Override
    default String getNodeType() {
        return DomEnums.label.getCode();
    }

    void setText(String text);

    String getText();

    void setFor(String elementId);

    String getFor();

}

package com.github.paohaijiao.dom.label;

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.enums.HtmlElementEnums;

public interface Label extends Dom {
    @Override
    default String getNodeType() {
        return HtmlElementEnums.label.getCode();
    }

    void setText(String text);

    String getText();

    void setFor(String elementId);

    String getFor();

}

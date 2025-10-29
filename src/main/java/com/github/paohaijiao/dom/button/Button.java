package com.github.paohaijiao.dom.button;

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.enums.HtmlElementEnums;

public interface Button extends Dom {
    @Override
    default String getNodeType() {
        return HtmlElementEnums.button.getCode();
    }

    void setText(String text);

    String getText();

    void setOnClick(String handler);

    String getOnClick();

    void setDisabled(boolean disabled);

    boolean isDisabled();
}

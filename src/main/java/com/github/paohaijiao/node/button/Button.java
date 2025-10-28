package com.github.paohaijiao.node.button;

import com.github.paohaijiao.common.Node;
import com.github.paohaijiao.enums.HtmlElementEnums;

public interface Button extends Node {
    @Override
    default String getNodeName() {
        return HtmlElementEnums.button.getCode();
    }

    void setText(String text);
    String getText();

    void setOnClick(String handler);

    String getOnClick();

    void setDisabled(boolean disabled);

    boolean isDisabled();
}

package com.github.paohaijiao.node.option;

import com.github.paohaijiao.common.Node;
import com.github.paohaijiao.enums.HtmlElementEnums;

public interface Option extends Node {
    @Override
    default String getNodeName() {
        return HtmlElementEnums.option.getCode();
    }

    void setValue(String value);
    String getValue();

    void setText(String text);
    String getText();

    void setSelected(boolean selected);
    boolean isSelected();
}

package com.github.paohaijiao.dom.option;

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.enums.DomEnums;

public interface Option extends Dom {
    @Override
    default String getNodeType() {
        return DomEnums.option.getCode();
    }

    void setValue(String value);
    String getValue();

    void setText(String text);
    String getText();

    void setSelected(boolean selected);
    boolean isSelected();
}

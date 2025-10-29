package com.github.paohaijiao.dom.option;

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.enums.HtmlElementEnums;

public interface Option extends Dom {
    @Override
    default String getNodeType() {
        return HtmlElementEnums.option.getCode();
    }

    void setValue(String value);
    String getValue();

    void setText(String text);
    String getText();

    void setSelected(boolean selected);
    boolean isSelected();
}

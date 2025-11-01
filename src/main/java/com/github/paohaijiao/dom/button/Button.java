package com.github.paohaijiao.dom.button;

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.enums.DomEnums;

public interface Button extends Dom {


    void setText(String text);

    String getText();

    void setOnClick(String handler);

    String getOnClick();

    void setDisabled(boolean disabled);

    boolean isDisabled();
}

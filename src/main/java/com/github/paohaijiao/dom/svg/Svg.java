package com.github.paohaijiao.dom.svg;

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.enums.DomEnums;

public interface Svg extends Dom {
    @Override
    default String getNodeType() {
        return DomEnums.svg.getCode();
    }
    void setId(String id);

    String getId();

    void setContent(String color);

    String getContent();
}

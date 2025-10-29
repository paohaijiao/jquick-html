package com.github.paohaijiao.dom.svg;

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.enums.HtmlElementEnums;

public interface Svg extends Dom {
    @Override
    default String getNodeType() {
        return HtmlElementEnums.svg.getCode();
    }
    void setId(String id);

    String getId();

    void setContent(String color);

    String getContent();
}

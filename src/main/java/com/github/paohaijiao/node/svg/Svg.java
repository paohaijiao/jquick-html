package com.github.paohaijiao.node.svg;

import com.github.paohaijiao.common.Node;
import com.github.paohaijiao.enums.HtmlElementEnums;

public interface Svg extends Node {
    @Override
    default String getNodeName() {
        return HtmlElementEnums.svg.getCode();
    }
    void setId(String id);

    String getId();

    void setContent(String color);

    String getContent();
}

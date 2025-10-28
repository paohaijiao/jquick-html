package com.github.paohaijiao.node.ol;

import com.github.paohaijiao.common.Container;
import com.github.paohaijiao.enums.HtmlElementEnums;

public interface Ol extends Container {
    @Override
    default String getNodeName() {
        return HtmlElementEnums.ol.getCode();
    }

    String getListStyle();

    void setListStyle(String style);
}

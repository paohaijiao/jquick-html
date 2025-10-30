package com.github.paohaijiao.dom.ol;

import com.github.paohaijiao.common.Container;
import com.github.paohaijiao.enums.DomEnums;

public interface Ol extends Container {
    @Override
    default String getNodeType() {
        return DomEnums.ol.getCode();
    }

    String getListStyle();

    void setListStyle(String style);
}

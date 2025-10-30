package com.github.paohaijiao.dom.ul;

import com.github.paohaijiao.common.Container;
import com.github.paohaijiao.enums.DomEnums;

public interface Ul  extends Container {
    @Override
    default String getNodeType() {
        return DomEnums.ul.getCode();
    }


    void setListStyle(String style);

    String getListStyle();
}

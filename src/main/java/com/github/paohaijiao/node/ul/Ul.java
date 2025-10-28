package com.github.paohaijiao.node.ul;

import com.github.paohaijiao.common.Container;
import com.github.paohaijiao.enums.HtmlElementEnums;

public interface Ul  extends Container {
    @Override
    default String getNodeName() {
        return HtmlElementEnums.ul.getCode();
    }


    void setListStyle(String style);

    String getListStyle();
}

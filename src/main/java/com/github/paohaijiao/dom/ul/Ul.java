package com.github.paohaijiao.dom.ul;

import com.github.paohaijiao.common.Container;
import com.github.paohaijiao.enums.HtmlElementEnums;

public interface Ul  extends Container {
    @Override
    default String getNodeType() {
        return HtmlElementEnums.ul.getCode();
    }


    void setListStyle(String style);

    String getListStyle();
}

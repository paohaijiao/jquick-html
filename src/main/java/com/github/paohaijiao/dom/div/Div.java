package com.github.paohaijiao.dom.div;

import com.github.paohaijiao.common.Container;
import com.github.paohaijiao.enums.HtmlElementEnums;

public interface Div extends Container {
    
    @Override
    default String getNodeType() {
        return HtmlElementEnums.div.getCode();
    }

    void setClassName(String className);

    String getClassName();
}

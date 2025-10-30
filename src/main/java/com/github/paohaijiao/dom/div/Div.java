package com.github.paohaijiao.dom.div;

import com.github.paohaijiao.common.Container;
import com.github.paohaijiao.enums.DomEnums;

public interface Div extends Container {
    
    @Override
    default String getNodeType() {
        return DomEnums.div.getCode();
    }

    void setClassName(String className);

    String getClassName();
}

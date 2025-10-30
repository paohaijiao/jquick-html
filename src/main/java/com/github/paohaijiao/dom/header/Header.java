package com.github.paohaijiao.dom.header;

import com.github.paohaijiao.common.Container;
import com.github.paohaijiao.enums.DomEnums;

public interface Header extends Container {
    @Override
    default String getNodeType() {
        return DomEnums.header.getCode();
    }
}

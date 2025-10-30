package com.github.paohaijiao.dom.aside;

import com.github.paohaijiao.common.Container;
import com.github.paohaijiao.enums.DomEnums;

public interface Aside extends Container {
    @Override
    default String getNodeType() {
        return DomEnums.aside.getCode();
    }
}

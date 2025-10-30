package com.github.paohaijiao.dom.thead;

import com.github.paohaijiao.common.Container;
import com.github.paohaijiao.enums.DomEnums;

public interface Thead extends Container {
    @Override
    default String getNodeType() {
        return DomEnums.thead.getCode();
    }
}

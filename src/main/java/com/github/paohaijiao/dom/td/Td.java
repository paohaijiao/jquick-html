package com.github.paohaijiao.dom.td;

import com.github.paohaijiao.common.Container;
import com.github.paohaijiao.enums.DomEnums;

public interface Td extends Container {
    @Override
    default String getNodeType() {
        return DomEnums.th.getCode();
    }

    void setColSpan(int span);

    int getColSpan();
}

package com.github.paohaijiao.dom.tr;

import com.github.paohaijiao.common.Container;
import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.enums.DomEnums;

public interface Tr extends Container {
    @Override
    default String getNodeType() {
        return DomEnums.tr.getCode();
    }

    void addCell(Dom cell);
}

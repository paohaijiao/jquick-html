package com.github.paohaijiao.dom.td;

import com.github.paohaijiao.common.Container;
import com.github.paohaijiao.enums.HtmlElementEnums;

public interface Td extends Container {
    @Override
    default String getNodeType() {
        return HtmlElementEnums.th.getCode();
    }

    void setColSpan(int span);

    int getColSpan();
}

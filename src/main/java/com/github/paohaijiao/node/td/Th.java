package com.github.paohaijiao.node.td;

import com.github.paohaijiao.common.Container;
import com.github.paohaijiao.enums.HtmlElementEnums;

public interface Th extends Container {
    @Override
    default String getNodeName() {
        return HtmlElementEnums.th.getCode();
    }

    void setColSpan(int span);

    int getColSpan();
}

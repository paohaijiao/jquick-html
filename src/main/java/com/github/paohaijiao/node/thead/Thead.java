package com.github.paohaijiao.node.thead;

import com.github.paohaijiao.common.Container;
import com.github.paohaijiao.enums.HtmlElementEnums;

public interface Thead extends Container {
    @Override
    default String getNodeName() {
        return HtmlElementEnums.thead.getCode();
    }
}

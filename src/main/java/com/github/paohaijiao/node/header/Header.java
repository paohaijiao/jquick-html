package com.github.paohaijiao.node.header;

import com.github.paohaijiao.common.Container;
import com.github.paohaijiao.enums.HtmlElementEnums;

public interface Header extends Container {
    @Override
    default String getNodeName() {
        return HtmlElementEnums.header.getCode();
    }
}

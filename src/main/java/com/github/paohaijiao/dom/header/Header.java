package com.github.paohaijiao.dom.header;

import com.github.paohaijiao.common.Container;
import com.github.paohaijiao.enums.HtmlElementEnums;

public interface Header extends Container {
    @Override
    default String getNodeType() {
        return HtmlElementEnums.header.getCode();
    }
}

package com.github.paohaijiao.dom.thead;

import com.github.paohaijiao.common.Container;
import com.github.paohaijiao.enums.HtmlElementEnums;

public interface Thead extends Container {
    @Override
    default String getNodeType() {
        return HtmlElementEnums.thead.getCode();
    }
}

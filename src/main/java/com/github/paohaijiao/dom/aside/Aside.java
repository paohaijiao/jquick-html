package com.github.paohaijiao.dom.aside;

import com.github.paohaijiao.common.Container;
import com.github.paohaijiao.enums.HtmlElementEnums;

public interface Aside extends Container {
    @Override
    default String getNodeType() {
        return HtmlElementEnums.aside.getCode();
    }
}

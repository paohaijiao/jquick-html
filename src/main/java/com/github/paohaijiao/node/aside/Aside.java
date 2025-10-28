package com.github.paohaijiao.node.aside;

import com.github.paohaijiao.common.Container;
import com.github.paohaijiao.enums.HtmlElementEnums;

public interface Aside extends Container {
    @Override
    default String getNodeName() {
        return HtmlElementEnums.aside.getCode();
    }
}

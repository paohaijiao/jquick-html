package com.github.paohaijiao.node.li;

import com.github.paohaijiao.common.Container;
import com.github.paohaijiao.enums.HtmlElementEnums;

public interface Li  extends Container {
    @Override
    default String getNodeName() {
        return HtmlElementEnums.li.getCode();
    }
}

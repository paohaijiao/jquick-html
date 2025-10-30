package com.github.paohaijiao.dom.li;

import com.github.paohaijiao.common.Container;
import com.github.paohaijiao.enums.DomEnums;

public interface Li  extends Container {
    @Override
    default String getNodeType() {
        return DomEnums.li.getCode();
    }
}

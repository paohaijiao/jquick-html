package com.github.paohaijiao.dom.li;

import com.github.paohaijiao.common.Container;
import com.github.paohaijiao.enums.HtmlElementEnums;

public interface Li  extends Container {
    @Override
    default String getNodeType() {
        return HtmlElementEnums.li.getCode();
    }
}

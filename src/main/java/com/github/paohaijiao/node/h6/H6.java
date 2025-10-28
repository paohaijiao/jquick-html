package com.github.paohaijiao.node.h6;

import com.github.paohaijiao.enums.HtmlElementEnums;
import com.github.paohaijiao.node.heading.Heading;

public interface H6 extends Heading {
    @Override
    default String getNodeName() {
        return HtmlElementEnums.h6.getCode();
    }

    @Override
    default int getLevel() {
        return 6;
    }
}

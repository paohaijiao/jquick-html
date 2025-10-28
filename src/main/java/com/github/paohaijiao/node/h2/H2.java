package com.github.paohaijiao.node.h2;

import com.github.paohaijiao.enums.HtmlElementEnums;
import com.github.paohaijiao.node.heading.Heading;

public interface H2 extends Heading {
    @Override
    default String getNodeName() {
        return HtmlElementEnums.h2.getCode();
    }

    @Override
    default int getLevel() {
        return 2;
    }
}

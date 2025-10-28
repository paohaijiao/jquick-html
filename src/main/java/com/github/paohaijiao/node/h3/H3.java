package com.github.paohaijiao.node.h3;

import com.github.paohaijiao.enums.HtmlElementEnums;
import com.github.paohaijiao.node.heading.Heading;

public interface H3 extends Heading {
    @Override
    default String getNodeName() {
        return HtmlElementEnums.h3.getCode();
    }

    @Override
    default int getLevel() {
        return 3;
    }
}

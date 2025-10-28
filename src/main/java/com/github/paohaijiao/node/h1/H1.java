package com.github.paohaijiao.node.h1;

import com.github.paohaijiao.enums.HtmlElementEnums;
import com.github.paohaijiao.node.heading.Heading;

public interface H1 extends Heading {
    @Override
    default String getNodeName() {
        return HtmlElementEnums.h1.getCode();
    }

    @Override
    default int getLevel() {
        return 1;
    }
}

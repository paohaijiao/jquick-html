package com.github.paohaijiao.node.h4;

import com.github.paohaijiao.enums.HtmlElementEnums;
import com.github.paohaijiao.node.heading.Heading;

public interface H4 extends Heading {
    @Override
    default String getNodeName() {
        return HtmlElementEnums.h4.getCode();
    }

    @Override
    default int getLevel() {
        return 4;
    }
}

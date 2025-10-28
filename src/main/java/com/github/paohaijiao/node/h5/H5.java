package com.github.paohaijiao.node.h5;

import com.github.paohaijiao.enums.HtmlElementEnums;
import com.github.paohaijiao.node.heading.Heading;

public interface H5 extends Heading {
    @Override
    default String getNodeName() {
        return HtmlElementEnums.h5.getCode();
    }

    @Override
    default int getLevel() {
        return 5;
    }
}

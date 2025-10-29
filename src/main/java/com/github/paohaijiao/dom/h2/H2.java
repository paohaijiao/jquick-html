package com.github.paohaijiao.dom.h2;

import com.github.paohaijiao.enums.HtmlElementEnums;
import com.github.paohaijiao.dom.heading.Heading;

public interface H2 extends Heading {
    @Override
    default String getNodeType() {
        return HtmlElementEnums.h2.getCode();
    }

    @Override
    default int getLevel() {
        return 2;
    }
}

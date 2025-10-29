package com.github.paohaijiao.dom.h1;

import com.github.paohaijiao.enums.HtmlElementEnums;
import com.github.paohaijiao.dom.heading.Heading;

public interface H1 extends Heading {
    @Override
    default String getNodeType() {
        return HtmlElementEnums.h1.getCode();
    }

    @Override
    default int getLevel() {
        return 1;
    }
}

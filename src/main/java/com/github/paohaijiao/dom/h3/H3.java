package com.github.paohaijiao.dom.h3;

import com.github.paohaijiao.enums.DomEnums;
import com.github.paohaijiao.dom.heading.Heading;

public interface H3 extends Heading {
    @Override
    default String getNodeType() {
        return DomEnums.h3.getCode();
    }

    @Override
    default int getLevel() {
        return 3;
    }
}

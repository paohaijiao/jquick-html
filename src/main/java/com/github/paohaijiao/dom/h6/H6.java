package com.github.paohaijiao.dom.h6;

import com.github.paohaijiao.enums.DomEnums;
import com.github.paohaijiao.dom.heading.Heading;

public interface H6 extends Heading {
    @Override
    default String getNodeType() {
        return DomEnums.h6.getCode();
    }

    @Override
    default int getLevel() {
        return 6;
    }
}

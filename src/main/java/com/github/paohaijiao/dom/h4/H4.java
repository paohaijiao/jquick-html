package com.github.paohaijiao.dom.h4;

import com.github.paohaijiao.enums.DomEnums;
import com.github.paohaijiao.dom.heading.Heading;

public interface H4 extends Heading {
    @Override
    default String getNodeType() {
        return DomEnums.h4.getCode();
    }

    @Override
    default int getLevel() {
        return 4;
    }
}

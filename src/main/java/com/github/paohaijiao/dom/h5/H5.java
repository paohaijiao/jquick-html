package com.github.paohaijiao.dom.h5;

import com.github.paohaijiao.enums.DomEnums;
import com.github.paohaijiao.dom.heading.Heading;

public interface H5 extends Heading {
    @Override
    default String getNodeType() {
        return DomEnums.h5.getCode();
    }

    @Override
    default int getLevel() {
        return 5;
    }
}

package com.github.paohaijiao.dom.main;

import com.github.paohaijiao.common.Container;
import com.github.paohaijiao.enums.HtmlElementEnums;

public interface Main  extends Container {
    @Override
    default String getNodeType() {
        return HtmlElementEnums.main.getCode();
    }
}

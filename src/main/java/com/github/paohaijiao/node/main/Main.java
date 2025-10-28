package com.github.paohaijiao.node.main;

import com.github.paohaijiao.common.Container;
import com.github.paohaijiao.enums.HtmlElementEnums;

public interface Main  extends Container {
    @Override
    default String getNodeName() {
        return HtmlElementEnums.main.getCode();
    }
}

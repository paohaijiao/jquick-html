package com.github.paohaijiao.common;

import com.github.paohaijiao.attr.AttrModel;

public interface AttributeProvider {

    public AttrModel getAttribute();

    public void setAttribute(AttrModel attributeProvider);
}

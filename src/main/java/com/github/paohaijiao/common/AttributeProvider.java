package com.github.paohaijiao.common;

import com.github.paohaijiao.model.AttrModel;

public interface AttributeProvider {

    public AttrModel getAttribute();

    public void setAttribute(AttrModel attributeProvider);

    public void putAttribute(String key, String value);

    public String getAttribute(String key);
}

package com.github.paohaijiao.common;

import com.github.paohaijiao.model.AttrModel;
import com.github.paohaijiao.provider.DomProvider;

public interface AttributeProvider extends DomProvider {

    public AttrModel getAttribute();

    public void setAttribute(AttrModel attributeProvider);

    public void putAttribute(String key, String value);

    public String getAttribute(String key);

    public String getDomAttrString();
}

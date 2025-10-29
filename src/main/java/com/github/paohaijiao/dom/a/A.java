package com.github.paohaijiao.dom.a;

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.enums.HtmlElementEnums;

public interface A extends Dom {
    @Override
    default String getNodeType() {
        return HtmlElementEnums.a.getCode();
    }

    void setHref(String url);

    String getHref();

    void setText(String text);

    String getText();

    void setTarget(String target);

    String getTarget();
}

package com.github.paohaijiao.node.a;

import com.github.paohaijiao.common.Node;
import com.github.paohaijiao.enums.HtmlElementEnums;

public interface A extends Node {
    @Override
    default String getNodeName() {
        return HtmlElementEnums.a.getCode();
    }

    void setHref(String url);

    String getHref();

    void setText(String text);

    String getText();

    void setTarget(String target);

    String getTarget();
}

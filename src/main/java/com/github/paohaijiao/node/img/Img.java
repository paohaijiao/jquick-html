package com.github.paohaijiao.node.img;

import com.github.paohaijiao.common.Node;
import com.github.paohaijiao.enums.HtmlElementEnums;

public interface Img extends Node {
    @Override
    default String getNodeName() {
        return HtmlElementEnums.img.getCode();
    }

    void setSrc(String url);

    String getSrc();


    void setAlt(String altText);

    String getAlt();

    void setWidth(int width);

    void setHeight(int height);

    int getWidth();

    int getHeight();
}

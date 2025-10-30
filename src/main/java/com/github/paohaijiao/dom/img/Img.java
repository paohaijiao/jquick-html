package com.github.paohaijiao.dom.img;

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.enums.DomEnums;

public interface Img extends Dom {
    @Override
    default String getNodeType() {
        return DomEnums.img.getCode();
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

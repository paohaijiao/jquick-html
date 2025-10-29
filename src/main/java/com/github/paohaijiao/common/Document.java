package com.github.paohaijiao.common;

import com.github.paohaijiao.dom.head.Head;

public interface Document {


    Head getHead();


    void setHead(Head head);


    Body getBody();


    void setBody(Body body);

    String getDoctype();

    void setDoctype(String doctype);
}

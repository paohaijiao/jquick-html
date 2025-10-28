package com.github.paohaijiao.common;

public interface Document {


    Head getHead();


    void setHead(Head head);


    Body getBody();


    void setBody(Body body);

    String getDoctype();

    void setDoctype(String doctype);
}

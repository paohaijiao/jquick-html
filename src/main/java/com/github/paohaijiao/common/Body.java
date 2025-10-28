package com.github.paohaijiao.common;

import java.util.List;

public interface Body extends Node{

    void addContent(Node content);

    List<Node> getContents();

    void setBackgroundColor(String color);


    String getBackgroundColor();

    void addEventHandler(String eventType, String handler);

    String getEventHandler(String eventType);
}

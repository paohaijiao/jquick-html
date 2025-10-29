package com.github.paohaijiao.common;

import java.util.List;

public interface Body extends Dom {

    void addContent(Dom content);

    List<Dom> getContents();

    void setBackgroundColor(String color);


    String getBackgroundColor();

    void addEventHandler(String eventType, String handler);

    String getEventHandler(String eventType);
}

package com.github.paohaijiao.common;


import java.util.List;

public interface Dom extends AttributeProvider {


    void addChild(Dom child);

    List<Dom> getChildren();

}

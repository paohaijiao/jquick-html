package com.github.paohaijiao.common;

import com.github.paohaijiao.provider.DomProvider;

import java.util.List;

public interface Dom extends DomProvider {


    void addChild(Dom child);

    List<Dom> getChildren();

}

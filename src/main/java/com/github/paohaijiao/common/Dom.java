package com.github.paohaijiao.common;

import com.github.paohaijiao.provider.ElementNodeProvider;

import java.util.List;

public interface Dom extends ElementNodeProvider {


    void addChild(Dom child);

    List<Dom> getChildren();

}

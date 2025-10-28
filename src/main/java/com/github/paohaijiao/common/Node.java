package com.github.paohaijiao.common;

import com.github.paohaijiao.provider.ElementNodeProvider;

import java.util.List;

public interface Node extends ElementNodeProvider {


    void addChild(Node child);

    List<Node> getChildren();

}

package com.github.paohaijiao.common;

import java.util.List;

public interface Container  extends Node {

    void addElement(Node element);

    boolean removeElement(Node element);

    List<Node> getElements();

}

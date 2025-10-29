package com.github.paohaijiao.common;

import java.util.List;

public interface Container  extends Dom {

    void addElement(Dom element);

    boolean removeElement(Dom element);

    List<Dom> getElements();

}

package com.github.paohaijiao.dom.table;

import com.github.paohaijiao.common.Container;
import com.github.paohaijiao.enums.DomEnums;
import com.github.paohaijiao.dom.thead.Thead;
import com.github.paohaijiao.dom.tr.Tr;

import java.util.List;

public interface Table extends Container {
    @Override
    default String getNodeType() {
        return DomEnums.table.getCode();
    }


    void setBorder(int borderWidth);

    int getBorderWidth();

    void setThead(Thead thead);

    Thead getThead();

    void addRow(Tr row);

    List<Tr> getRows();
}

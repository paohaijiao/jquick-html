package com.github.paohaijiao.node.select;

import com.github.paohaijiao.common.Node;
import com.github.paohaijiao.enums.HtmlElementEnums;
import com.github.paohaijiao.node.option.Option;

import java.util.List;

public interface Select extends Node {
    @Override
    default String getNodeName() {
        return HtmlElementEnums.select.getCode();
    }


    void addOption(Option option);

    List<Option> getOptions();

    void setSelectedIndex(int index);

    int getSelectedIndex();

    void setMultiple(boolean multiple);

    boolean isMultiple();
}

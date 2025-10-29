package com.github.paohaijiao.dom.select;

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.enums.HtmlElementEnums;
import com.github.paohaijiao.dom.option.Option;

import java.util.List;

public interface Select extends Dom {
    @Override
    default String getNodeType() {
        return HtmlElementEnums.select.getCode();
    }


    void addOption(Option option);

    List<Option> getOptions();

    void setSelectedIndex(int index);

    int getSelectedIndex();

    void setMultiple(boolean multiple);

    boolean isMultiple();
}

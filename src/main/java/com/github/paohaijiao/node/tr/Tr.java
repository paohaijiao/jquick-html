package com.github.paohaijiao.node.tr;

import com.github.paohaijiao.common.Container;
import com.github.paohaijiao.common.Node;
import com.github.paohaijiao.enums.HtmlElementEnums;

public interface Tr extends Container {
    @Override
    default String getNodeName() {
        return HtmlElementEnums.tr.getCode();
    }

    void addCell(Node cell); // 可包含 th 或 td
}

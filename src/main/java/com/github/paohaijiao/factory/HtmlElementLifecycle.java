package com.github.paohaijiao.factory;

import com.github.paohaijiao.common.Dom;

public interface HtmlElementLifecycle extends Dom {
    // 初始化元素
    void init();

    // 元素渲染前
    void beforeRender();

    // 元素渲染后
    void afterRender();

    // 销毁元素
    void destroy();
}

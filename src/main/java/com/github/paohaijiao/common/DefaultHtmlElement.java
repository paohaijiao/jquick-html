package com.github.paohaijiao.common;

import com.github.paohaijiao.console.JConsole;
import com.github.paohaijiao.dom.abs.AbsDom;
import com.github.paohaijiao.enums.JLogLevel;
import com.github.paohaijiao.factory.HtmlElementLifecycle;

import java.util.ArrayList;
import java.util.List;

public class DefaultHtmlElement extends AbsDom implements HtmlElementLifecycle {
    private JConsole console=new JConsole();

    private final String code;

    private final List<String> aliases;

    private final List<Dom> children = new ArrayList<>();

    public DefaultHtmlElement(String code, List<String> aliases) {
        this.code = code;
        this.aliases = aliases;
    }



    @Override
    public String getNodeType() {
        return code;
    }

    @Override
    public void init() {
        console.log(JLogLevel.INFO, "Initializing default element: " + code);
    }

    @Override
    public void beforeRender() {
        console.log(JLogLevel.INFO, "Before rendering element: " + code);
    }

    @Override
    public void afterRender() {
        console.log(JLogLevel.INFO, "After rendering element: " + code);
    }

    @Override
    public void destroy() {
        console.log(JLogLevel.INFO, "Destroying element: " + code);
        children.clear();
    }

    @Override
    public void addChild(Dom child) {
        children.add(child);
    }

    @Override
    public List<Dom> getChildren() {
        return new ArrayList<>(children);
    }
}

package com.github.paohaijiao.dom.header;

import com.github.paohaijiao.dom.h6.impl.H6Impl;
import com.github.paohaijiao.dom.header.impl.HeaderImpl;
import com.github.paohaijiao.dom.p.impl.PImpl;
import org.junit.Test;

public class HeaderTest {

    public static HeaderImpl h1 = new HeaderImpl();

    @Test
    public void div() {
        System.out.println(h1);
    }

    @Test
    public void div1() {
        h1.putAttribute("id","sidebar");
        System.out.println(h1);
    }

    @Test
    public void testAsideWithClassName() {
        h1.putAttribute("className","sidebar-primary");
        System.out.println(h1);
    }

    @Test
    public void testAsideWithAriaLabel() {
        h1.putAttribute("AriaLabel","Main sidebar");
        System.out.println(h1);
    }

    @Test
    public void testAsideWithAllAttributes() {
        h1.putAttribute("id","sidebar");
        h1.putAttribute("className","sidebar-primary");
        h1.putAttribute("AriaLabel","Main sidebar");
        System.out.println(h1);
    }

    @Test
    public void testAsideWithTextChild() {
        h1.putStyle("height","100%");
        h1.putStyle("width","100%");
        PImpl paragraph = new PImpl();
        paragraph.setText("This is a sidebar content");
        h1.addChild(paragraph);
        System.out.println(h1);
    }
}

package com.github.paohaijiao.dom.aside;


import com.github.paohaijiao.dom.aside.impl.AsideImpl;
import com.github.paohaijiao.dom.div.impl.DivImpl;
import com.github.paohaijiao.dom.p.impl.PImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class AsideTest {

    @Test
    public void testBasicAside() {
        AsideImpl aside = new AsideImpl();
        System.out.println(aside);
    }

    @Test
    public void testAsideWithId() {
        AsideImpl aside = new AsideImpl();
        aside.setId("sidebar");
        System.out.println(aside);
    }

    @Test
    public void testAsideWithClassName() {
        AsideImpl aside = new AsideImpl();
        aside.setClassName("sidebar-primary");
        System.out.println(aside);
    }

    @Test
    public void testAsideWithAriaLabel() {
        AsideImpl aside = new AsideImpl();
        aside.setAriaLabel("Main sidebar");
        System.out.println(aside);
    }

    @Test
    public void testAsideWithAllAttributes() {
        AsideImpl aside = new AsideImpl();
        aside.setId("main-sidebar");
        aside.setClassName("sidebar dark-theme");
        aside.setAriaLabel("Primary navigation");
        System.out.println(aside);
    }

    @Test
    public void testAsideWithTextChild() {
        AsideImpl aside = new AsideImpl();
        PImpl paragraph = new PImpl();
        paragraph.setText("This is a sidebar content");
        aside.addChild(paragraph);

        System.out.println(aside);
    }

    @Test
    public void testAsideWithMultipleChildren() {
        AsideImpl aside = new AsideImpl();

        DivImpl div1 = new DivImpl();
        div1.setId("widget-1");

        DivImpl div2 = new DivImpl();
        div2.setClassName("widget");

        PImpl paragraph = new PImpl();
        paragraph.setText("Sidebar text content");

        aside.addChild(div1);
        aside.addChild(div2);
        aside.addChild(paragraph);

        System.out.println(aside);
    }

    @Test
    public void testAsideWithNestedChildren() {
        AsideImpl aside = new AsideImpl();
        aside.setId("nested-sidebar");
        DivImpl container = new DivImpl();
        container.setClassName("container");
        PImpl paragraph = new PImpl();
        paragraph.setText("Nested content");
        container.addChild(paragraph);
        aside.addChild(container);
        System.out.println(aside);
    }

    @Test
    public void testAsideWithMixedContent() {
        AsideImpl aside = new AsideImpl();
        aside.setClassName("mixed-sidebar");
        aside.setAriaLabel("Mixed content sidebar");
        DivImpl div = new DivImpl();
        div.setId("header");
        aside.addChild(div);
        PImpl paragraph = new PImpl();
        paragraph.setText("Some text content");
        aside.addChild(paragraph);
        DivImpl footer = new DivImpl();
        footer.setClassName("footer");
        aside.addChild(footer);
        System.out.println(aside);
    }

    @Test
    public void testEmptyAttributes() {
        AsideImpl aside = new AsideImpl();
        aside.setId("");
        aside.setClassName("");
        aside.setAriaLabel("");
        System.out.println(aside);
    }

    @Test
    public void testNullAttributes() {
        AsideImpl aside = new AsideImpl();
        aside.setId(null);
        aside.setClassName(null);
        aside.setAriaLabel(null);
        System.out.println(aside);
    }
}

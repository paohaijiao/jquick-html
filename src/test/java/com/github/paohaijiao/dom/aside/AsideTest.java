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
        aside.putAttribute("id","sidebar");
        System.out.println(aside);
    }

    @Test
    public void testAsideWithClassName() {
        AsideImpl aside = new AsideImpl();
        aside.putAttribute("className","sidebar-primary");
        System.out.println(aside);
    }

    @Test
    public void testAsideWithAriaLabel() {
        AsideImpl aside = new AsideImpl();
        aside.putAttribute("AriaLabel","Main sidebar");
        System.out.println(aside);
    }

    @Test
    public void testAsideWithAllAttributes() {
        AsideImpl aside = new AsideImpl();
        aside.putAttribute("id","sidebar");
        aside.putAttribute("className","sidebar-primary");
        aside.putAttribute("AriaLabel","Main sidebar");
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
        div1.putAttribute("id","widget-1");

        DivImpl div2 = new DivImpl();
        div2.putAttribute("ClassName","widget-1");

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
        aside.putAttribute("AriaLabel","Main sidebar");
        DivImpl container = new DivImpl();
        container.putAttribute("ClassName","container");
        PImpl paragraph = new PImpl();
        paragraph.setText("Nested content");
        container.addChild(paragraph);
        aside.addChild(container);
        System.out.println(aside);
    }

    @Test
    public void testAsideWithMixedContent() {
        AsideImpl aside = new AsideImpl();
        aside.putAttribute("className","sidebar-primary");
        aside.putAttribute("AriaLabel","Main sidebar");
        DivImpl div = new DivImpl();
        div.putAttribute("id","widget-1");
        aside.addChild(div);
        PImpl paragraph = new PImpl();
        paragraph.setText("Some text content");
        aside.addChild(paragraph);
        DivImpl footer = new DivImpl();
        div.putAttribute("className","footer");
        aside.addChild(footer);
        System.out.println(aside);
    }

    @Test
    public void testEmptyAttributes() {
        AsideImpl aside = new AsideImpl();
        aside.putAttribute("className","sidebar-primary");
        aside.putAttribute("AriaLabel","Main sidebar");
        System.out.println(aside);
    }

    @Test
    public void testNullAttributes() {
        AsideImpl aside = new AsideImpl();
        aside.putAttribute("className","sidebar-primary");
        aside.putAttribute("AriaLabel","Main sidebar");
        System.out.println(aside);
    }
}

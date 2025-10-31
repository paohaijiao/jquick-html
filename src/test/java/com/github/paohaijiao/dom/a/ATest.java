package com.github.paohaijiao.dom.a;


import com.github.paohaijiao.dom.a.impl.AImpl;
import com.github.paohaijiao.dom.div.impl.DivImpl;
import org.junit.Test;

public class ATest {
    @Test
    public void href() throws InterruptedException {
        String href = "https://example.com";
        AImpl a = new AImpl();
        a.setHref(href);
        System.out.println(a.toString());
    }
    @Test
    public void text() throws InterruptedException {
        String text = "Click here";
        AImpl a = new AImpl();
        a.setText(text);
        System.out.println(a.toString());
    }
    @Test
    public void target() throws InterruptedException {
        String target = "_blank";
        AImpl a = new AImpl();
        a.setTarget(target);
        System.out.println(a.toString());
    }
    @Test
    public void child() throws InterruptedException {
        AImpl a = new AImpl();
        DivImpl child1 = new DivImpl();
        DivImpl child2 = new DivImpl() ;

        a.addChild(child1);
        a.addChild(child2);

        System.out.println(a.toString());
    }
}

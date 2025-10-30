package com.github.paohaijiao.dom.doc;

import com.github.paohaijiao.common.Body;
import com.github.paohaijiao.common.Document;
import com.github.paohaijiao.dom.body.BodyImpl;
import com.github.paohaijiao.dom.document.DocumentImpl;
import com.github.paohaijiao.dom.h1.impl.H1Impl;
import com.github.paohaijiao.dom.doc.impl.HeadImpl;
import org.junit.Test;

public class DocTest {

    private Document document;

    private Head testHead;

    private Body testBody;

    @Test
    public void document() {
        DocumentImpl document = new DocumentImpl();
        System.out.println(document);
    }
    @Test
    public void document1() {
        DocumentImpl document = new DocumentImpl();
        document.setDoctype("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\">");
        Head head = new HeadImpl();
        document.setHead(head);
        Body body = new BodyImpl();
        document.setBody(body);
        System.out.println(document.toString());
    }
    @Test
    public void document2() {
        DocumentImpl document = new DocumentImpl();
        Body body = new BodyImpl();
        document.setBody(body);
        System.out.println( document.toString());
    }

    @Test
    public  void doc() throws Exception {
        Document doc = new DocumentImpl();
        doc.setDoctype("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" " + "\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
        System.out.println(doc.toString());
    }
    @Test
    public  void doc1() throws Exception {
        Document doc = new DocumentImpl();
        Body body = new BodyImpl();
        Head head = new HeadImpl();
        head.setTitle("完整文档测试");
        head.addMeta("author", "test");
        body.addContent(new H1Impl());
        doc.setHead(head);
        doc.setBody(body);
        String fullDocStr = doc.toString();
        System.out.println(fullDocStr);
    }
}

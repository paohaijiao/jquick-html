package com.github.paohaijiao.dom.document;

import com.github.paohaijiao.common.Document;

import com.github.paohaijiao.common.Body;
import com.github.paohaijiao.console.JConsole;
import com.github.paohaijiao.dom.doc.Head;
import com.github.paohaijiao.enums.JLogLevel;

/**
 * Document接口实现类，对应整个HTML文档
 */
public class DocumentImpl implements Document {

    private Head head;

    private Body body;

    private String doctype = "<!DOCTYPE html>";

    private final JConsole console = new JConsole();

    @Override
    public void setHead(Head head) {
        this.head = head;
        console.log(JLogLevel.DEBUG, "Set head for document");
    }

    @Override
    public Head getHead() {
        return head;
    }

    @Override
    public void setBody(Body body) {
        this.body = body;
        console.log(JLogLevel.DEBUG, "Set body for document");
    }

    @Override
    public String getDoctype() {
        return doctype;
    }

    @Override
    public Body getBody() {
        return body;
    }

    @Override
    public void setDoctype(String doctype) {
        if (doctype != null && !doctype.trim().isEmpty()) {
            this.doctype = doctype.trim();
            console.log(JLogLevel.DEBUG, "Set document doctype to: " + doctype);
        } else {
            console.log(JLogLevel.WARN, "Invalid doctype, using default");
            this.doctype = "<!DOCTYPE html>"; // 无效值时使用默认
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(doctype).append("\n");
        sb.append("<html>\n");
        if (head != null) {
            sb.append("  ").append(head.toString().replace("\n", "\n  ")).append("\n");
        } else {
            sb.append("  <head>\n");
            sb.append("  <head/>\n");
        }
        if (body != null) {
            sb.append("  ").append(body.toString().replace("\n", "\n  ")).append("\n");
        } else {
            sb.append("  <body>\n");
            sb.append("  <body/>\n");
        }
        sb.append("</html>");
        return sb.toString();
    }
}

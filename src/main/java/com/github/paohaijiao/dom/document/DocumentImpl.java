package com.github.paohaijiao.dom.document;

import com.github.paohaijiao.common.Document;

import com.github.paohaijiao.common.Body;
import com.github.paohaijiao.console.JConsole;
import com.github.paohaijiao.dom.abs.AbsDom;
import com.github.paohaijiao.dom.head.Head;
import com.github.paohaijiao.enums.DomEnums;
import com.github.paohaijiao.enums.JLogLevel;

/**
 * Document接口实现类，对应整个HTML文档
 */
public class DocumentImpl extends AbsDom implements Document {

    private Head head;

    private String lang="\"zh-CN\"";

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
        sb.append(doctype);
        if(lang!=null){
            sb.append("<html lang="+lang+">\n");
        }else{
            sb.append("<html>\n");
        }
        if (head != null) {
            sb.append(head.toString());
        }
        if (body != null) {
            sb.append(body.toString());
        }
        sb.append("</html>");
        return prettyPrint(sb.toString());
    }

    @Override
    public String getNodeType() {
        return DomEnums.document.getCode();
    }
}

package com.github.paohaijiao.dom.head;

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.dom.link.Link;
import com.github.paohaijiao.dom.meta.Meta;
import com.github.paohaijiao.dom.script.Script;

import java.util.List;

public interface Head extends Dom {

    void setTitle(String title);

    String getTitle();

    void addMeta(Meta meta);

    List<Meta> getMetaList();

    void addLink(Link link);

    List<Link> getLinkList();

    void addScript(Script script);

    List<Script> getScripts();


}

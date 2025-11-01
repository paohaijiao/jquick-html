package com.github.paohaijiao.dom.head;

import com.github.paohaijiao.common.Dom;

import java.util.List;

public interface Head extends Dom {

    void setTitle(String title);

    String getTitle();

    void addMeta(String name, String content);

    List<Meta> getMetas();

    void addStyleSheet(String href);

    List<String> getStyleSheets();

    void addScript(String src);

    List<String> getScripts();

    class Meta {
        private final String name;
        private final String content;

        public Meta(String name, String content) {
            this.name = name;
            this.content = content;
        }

        public String getName() { return name; }
        public String getContent() { return content; }
    }
}

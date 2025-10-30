/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Copyright (c) [2025-2099] Martin (goudingcheng@gmail.com)
 */
package com.github.paohaijiao.dom.doc.impl;

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.dom.doc.Head;
import com.github.paohaijiao.enums.HtmlElementEnums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * packageName com.github.paohaijiao.dom.head.impl
 *
 * @author Martin
 * @version 1.0.0
 * @since 2025/10/29
 */
public class HeadImpl implements Head {

    private String title;

    private final List<Meta> metas = new ArrayList<>();

    private final List<String> styleSheets = new ArrayList<>();

    private final List<String> scripts = new ArrayList<>();

    private final List<Dom> children = new ArrayList<>();


    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void addMeta(String name, String content) {
        metas.add(new Meta(name, content));
    }

    @Override
    public List<Meta> getMetas() {
        return Collections.unmodifiableList(new ArrayList<>(metas));
    }

    @Override
    public void addStyleSheet(String href) {
        styleSheets.add(href);
    }

    @Override
    public List<String> getStyleSheets() {
        return Collections.unmodifiableList(new ArrayList<>(styleSheets));
    }

    @Override
    public void addScript(String src) {
        scripts.add(src);
    }

    @Override
    public List<String> getScripts() {
        return Collections.unmodifiableList(new ArrayList<>(scripts));
    }

    @Override
    public void addChild(Dom child) {
        if (child != null) {
            children.add(child);
        }
    }

    @Override
    public List<Dom> getChildren() {
        return Collections.unmodifiableList(new ArrayList<>(children));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<head>");
        if (title != null && !title.isEmpty()) {
            sb.append("\n  <title>").append(title).append("</title>");
        }
        for (Meta meta : metas) {
            sb.append("\n  <meta name=\"").append(meta.getName()).append("\" content=\"").append(meta.getContent()).append("\"/>");
        }
        for (String styleSheet : styleSheets) {
            sb.append("\n  <link rel=\"stylesheet\" href=\"").append(styleSheet).append("\"/>");
        }
        for (String script : scripts) {
            sb.append("\n  <script src=\"").append(script).append("\"></script>");
        }
        for (Dom child : children) {
            sb.append("\n  ").append(child.toString().replace("\n", "\n  "));
        }
        sb.append("\n</head>");
        return sb.toString();
    }

    @Override
    public String getNodeType() {
        return HtmlElementEnums.head.getCode();
    }
}

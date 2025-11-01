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
package com.github.paohaijiao.dom.abs;

import com.github.paohaijiao.common.AttributeProvider;
import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.console.JConsole;
import com.github.paohaijiao.enums.JLogLevel;
import com.github.paohaijiao.model.AttrModel;
import com.github.paohaijiao.style.Style;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.Map;

/**
 * packageName com.github.paohaijiao.dom.abs
 *
 * @author Martin
 * @version 1.0.0
 * @since 2025/10/31
 */
public abstract class AbsDom implements AttributeProvider {
    JConsole console=new JConsole();

    protected AttrModel attributes=new AttrModel();
    protected Style style=new Style();

    @Override
    public AttrModel getAttribute() {
        return attributes;
    }

    @Override
    public void setAttribute(AttrModel attribute) {
        this.attributes = attribute;
        console.log(JLogLevel.DEBUG, "Set attributes for <body>");
    }
    public void putAttribute(String key, String value){
        attributes.put(key,value);
    }

    public String getAttribute(String key){
        return   attributes.get(key);
    }

    public String toAttrString() {
        StringBuilder sb = new StringBuilder();
        if (attributes != null && !attributes.isEmpty()) {
            for (Map.Entry<String, String> entry : attributes.entrySet()) {
                sb.append(" ").append(entry.getKey()).append("=\"").append(entry.getValue()).append("\"");
            }
        }
        return sb.toString();
    }

    protected String prettyPrint(String html) {
        try {
            Document doc = Jsoup.parse(html);
            doc.outputSettings()
                    .indentAmount(2)
                    .prettyPrint(true)
                    .outline(true);
            return doc.body().html().trim();
        } catch (Exception e) {
            return html;
        }
    }
    public Style getStyle() {
        return style;
    }
    public void putStyle(String key,String value) {
        Style style=this.getStyle();
        style.put(key,value);
    }

    public String toStyleString() {
        String style=" style=\"%s\"";
        return String.format(style,this.style.toStyleString());
    }
}

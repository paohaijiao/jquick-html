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
import com.github.paohaijiao.console.JConsole;
import com.github.paohaijiao.enums.JLogLevel;
import com.github.paohaijiao.model.AttrModel;
import com.github.paohaijiao.style.Style;
import net.htmlparser.jericho.CharacterReference;
import net.htmlparser.jericho.Segment;
import net.htmlparser.jericho.Source;
import net.htmlparser.jericho.Tag;

import java.io.StringWriter;
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
            Source source = new Source(html);
            StringWriter writer = new StringWriter();
            for (Segment segment : source) {
                if (segment instanceof Tag) {
                    Tag tag = (Tag) segment;
                    writer.write(tag.toString());
                } else if (segment instanceof CharacterReference) {
                    CharacterReference charRef = (CharacterReference) segment;
                    writer.write(charRef.toString());
                } else {
                    String text = segment.toString();
                    writer.write(text);
                }
            }
            return formatWithIndentation(writer.toString());
        } catch (Exception e) {
            console.error("Jericho格式化时出错: " ,e);
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
    private static String formatWithIndentation(String html) {
        String[] lines = html.split("(?=<[^>]*>)|(?<=>)");
        StringBuilder result = new StringBuilder();
        int indent = 0;
        for (String line : lines) {
            line = line.trim();
            if (line.isEmpty()) continue;
            if (line.startsWith("</")) {
                indent = Math.max(0, indent - 1);
            }
            for (int i = 0; i < indent; i++) {
                result.append("    ");
            }
            result.append(line).append("\n");
            if (line.startsWith("<") && !line.startsWith("</") &&
                    !line.endsWith("/>") && !isVoidElement(line)) {
                indent++;
            }
        }
        return result.toString();
    }

    private static boolean isVoidElement(String tag) {
        return tag.matches("^<(area|base|br|col|embed|hr|img|input|keygen|link|meta|param|source|track|wbr).*");
    }

    public String getWidth(){
        return this.attributes.get("width");
    }

    public String getHeight(){
        return this.attributes.get("height");
    }

    public String getColor(){
        return this.attributes.get("color");
    }


}

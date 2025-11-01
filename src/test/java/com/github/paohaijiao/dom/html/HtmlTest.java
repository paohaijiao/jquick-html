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
package com.github.paohaijiao.dom.html;

import com.github.paohaijiao.dom.document.DocumentImpl;
import com.github.paohaijiao.dom.head.impl.HeadImpl;
import com.github.paohaijiao.dom.header.impl.HeaderImpl;
import com.github.paohaijiao.dom.link.Link;
import com.github.paohaijiao.dom.meta.Meta;
import com.github.paohaijiao.dom.script.Script;
import org.junit.Test;

/**
 * packageName com.github.paohaijiao.dom.html
 *
 * @author Martin
 * @version 1.0.0
 * @since 2025/11/1
 */
public class HtmlTest {
    public static DocumentImpl document = new DocumentImpl();
    @Test
    public void html() {
        document.setHead(buildHead());

        System.out.println(document);
    }
    private static HeadImpl buildHead() {
        HeadImpl head = new HeadImpl();
        Meta meta = new Meta();
        meta.setCharset("utf-8");
        head.addMeta(meta);
        Meta meta1 = new Meta();
        meta1.setContent("width=device-width, initial-scale=1.0");
        meta1.setName("viewport");
        head.addMeta(meta1);
        head.setTitle("交互式数据报表");
        Script script = new Script();
        script.setSrc("https://cdn.tailwindcss.com");
        head.addScript(script);
        Link link = new Link();
        link.setHref("https://cdn.jsdelivr.net/npm/font-awesome@4.7.0/css/font-awesome.min.css");
        link.setRel("stylesheet");
        head.addLink(link);
        Script script1 = new Script();
        script1.setText("tailwind.config = {\n" +
                "            theme: {\n" +
                "                extend: {\n" +
                "                    colors: {\n" +
                "                        primary: '#165DFF',\n" +
                "                        secondary: '#36CFC9',\n" +
                "                        success: '#52C41A',\n" +
                "                        warning: '#FAAD14',\n" +
                "                        danger: '#FF4D4F',\n" +
                "                        info: '#40A9FF',\n" +
                "                        dark: '#1D2129',\n" +
                "                        'light-dark': '#4E5969',\n" +
                "                        'ultra-light': '#F2F3F5'\n" +
                "                    },\n" +
                "                    fontFamily: {\n" +
                "                        inter: ['Inter', 'system-ui', 'sans-serif'],\n" +
                "                    },\n" +
                "                },\n" +
                "            }\n" +
                "        }");
        head.addScript(script1);
        return head;
    }
}

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
package com.github.paohaijiao.render;

import com.github.paohaijiao.common.Body;
import com.github.paohaijiao.dom.body.BodyImpl;
import com.github.paohaijiao.dom.button.Button;
import com.github.paohaijiao.dom.button.impl.ButtonImpl;
import com.github.paohaijiao.dom.head.Head;
import com.github.paohaijiao.dom.head.impl.HeadImpl;
import com.github.paohaijiao.dom.html.HtmlImpl;
import com.github.paohaijiao.dom.p.P;
import com.github.paohaijiao.dom.p.impl.PImpl;
import com.github.paohaijiao.script.Script;
import com.github.paohaijiao.script.impl.ExternalScript;
import com.github.paohaijiao.style.Style;

public class HtmlRendererDemo {

    public static void main(String[] args) {
        HtmlRenderer renderer = new HtmlRenderer();
        HtmlImpl html = new HtmlImpl("html");
        Head head = new HeadImpl();
        head.setTitle("测试页面");
        head.addMeta("charset", "UTF-8");
        head.addMeta("viewport", "width=device-width, initial-scale=1.0");
        Style style = new Style();
        style.setContent("body { font-family: Arial, sans-serif; line-height: 1.6; }");
       // head.addChild(style);
        Script script = new ExternalScript("https://code.jquery.com/jquery-3.6.0.min.js");
        script.setLoadStrategy(Script.LoadStrategy.DEFER);
       // head.addChild(script);

        html.addChild(head);

        // 创建Body元素
        Body body = new BodyImpl();
       // body.setStyle("background-color", "#f5f5f5");

        // 添加标题
//        Head h1 = new HeadImpl(1, "HTML渲染器测试");
//        body.addChild(h1);

        P p = new PImpl();
        p.setText("这是一个<strong>测试</strong>段落，包含特殊字符：<script>alert('hello')</script>");
        body.addChild(p);
        Button button = new ButtonImpl();
        button.setText("点击我" );
//        button.addAttribute("id", "testBtn");
//        button.addEventHandler("click", "handleClick()");
        body.addChild(button);

        html.addChild(body);

        // 渲染为完整HTML文档
        String htmlDocument = renderer.renderToHtmlDocument("<!DOCTYPE html>", html);
        System.out.println(htmlDocument);
    }
}

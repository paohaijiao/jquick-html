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
package com.github.paohaijiao.context;

import com.github.paohaijiao.common.Body;
import com.github.paohaijiao.context.impl.PageContext;
import com.github.paohaijiao.dom.body.BodyImpl;
import com.github.paohaijiao.dom.button.impl.ButtonImpl;
import com.github.paohaijiao.dom.head.Head;
import com.github.paohaijiao.dom.head.impl.HeadImpl;
import com.github.paohaijiao.event.handler.impl.ClickEventHandler;
import com.github.paohaijiao.script.impl.ExternalScript;
import com.github.paohaijiao.script.impl.InlineScript;
import org.junit.Test;

/**
 * packageName com.github.paohaijiao.context
 *
 * @author Martin
 * @version 1.0.0
 * @since 2025/10/30
 */
public class ContextTest {
    @Test
    public void document() throws InterruptedException {
        Context context = new PageContext();
        Head head = new HeadImpl();
        head.setTitle("Context Demo");
        Body body = new BodyImpl();
        ((PageContext) context).getDocument().setHead(head);
        ((PageContext) context).getDocument().setBody(body);

        ButtonImpl button = new ButtonImpl();
        // button.setAttribute(new AttrModel().add("id", "submitBtn").add("text", "点击我"));
        context.addElement(button);
        context.addEventHandler(button, new ClickEventHandler((source, event) -> {
            System.out.println("按钮被点击！会话ID：" + context.getSession().getId());
        }));
        ExternalScript jquery = new ExternalScript("https://code.jquery.com/jquery-3.6.0.min.js");
        context.addScript(jquery);

        InlineScript inlineScript = new InlineScript("console.log('页面加载完成');");
        context.addScript(inlineScript);
        context.getSession().setAttribute("username", "testUser");
        System.out.println("当前会话用户：" + context.getSession().getAttribute("username"));
        String html = context.renderHtml();
        System.out.println("生成的HTML：\n" + html);
        context.triggerEvent(button, "click");
    }
}

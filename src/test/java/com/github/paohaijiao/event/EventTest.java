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
package com.github.paohaijiao.event;
import com.github.paohaijiao.dom.button.impl.ButtonImpl;
import com.github.paohaijiao.dom.document.DocumentImpl;
import com.github.paohaijiao.event.handler.impl.ClickEventHandler;
import com.github.paohaijiao.event.handler.impl.DoubleClickEventHandler;
import com.github.paohaijiao.event.manager.EventManager;
import com.github.paohaijiao.event.model.Event;
import org.junit.Test;

/**
 * packageName com.github.paohaijiao.event
 *
 * @author Martin
 * @version 1.0.0
 * @since 2025/10/30
 */
public class EventTest {

    @Test
    public void document() {
        ButtonImpl button = new ButtonImpl();
        EventManager eventManager = new EventManager();
        eventManager.addEventHandler(button, new ClickEventHandler((source, event) -> {
            System.out.println("按钮被单击！时间：" + event.getTimestamp());
            System.out.println("触发元素：" + source.getNodeType());
        }));
        eventManager.addEventHandler(button, new DoubleClickEventHandler((source, event) -> {
            System.out.println("按钮被双击！参数：" + event.getParam("msg"));
        }));
        Event clickEvent = new Event("click", button);
        eventManager.triggerEvent(button, clickEvent);
        Event dblClickEvent = new Event("dblclick", button);
        dblClickEvent.addParam("msg", "双击确认");
        eventManager.triggerEvent(button, dblClickEvent);
    }
}

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
package com.github.paohaijiao.layout;

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.dom.button.impl.ButtonImpl;
import com.github.paohaijiao.dom.div.impl.DivImpl;
import com.github.paohaijiao.event.handler.impl.ClickEventHandler;
import com.github.paohaijiao.event.handler.impl.DoubleClickEventHandler;
import com.github.paohaijiao.event.manager.EventManager;
import com.github.paohaijiao.event.model.Event;
import com.github.paohaijiao.layout.impl.FlexLayout;
import com.github.paohaijiao.layout.params.LayoutParams;
import com.github.paohaijiao.model.AttrModel;
import org.junit.Test;

/**
 * packageName com.github.paohaijiao.layout
 *
 * @author Martin
 * @version 1.0.0
 * @since 2025/10/30
 */
public class LayoutTest {
    @Test
    public void document() {
        Layout flexLayout = new FlexLayout();
        flexLayout.setLayoutParams(new LayoutParams()
                .add("flex-direction", "column")
                .add("justify-content", "space-between")
                .add("height", "300px")
                .add("border", "1px solid #ccc"));
        // 创建子元素
        Dom header = new DivImpl();
        //header.setAttribute(new AttrModel().add("style", "background: #f0f0f0"));

        Dom content = new DivImpl();
        //content.setAttribute(new AttrModel().add("style", "flex: 1")); // 占满剩余空间
        flexLayout.addChild(header, new LayoutParams().add("height", "50px"));
        flexLayout.addChild(content, null);
        flexLayout.layout(800, 300);
        System.out.println(flexLayout.toHtml());
    }
}

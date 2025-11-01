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
package com.github.paohaijiao.dom.button;

import com.github.paohaijiao.dom.aside.impl.AsideImpl;
import com.github.paohaijiao.dom.button.impl.ButtonImpl;
import com.github.paohaijiao.dom.div.impl.DivImpl;
import com.github.paohaijiao.dom.p.impl.PImpl;
import org.junit.Test;

/**
 * packageName com.github.paohaijiao.dom.doc
 *
 * @author Martin
 * @version 1.0.0
 * @since 2025/11/1
 */
public class ButtonTest {
    @Test
    public void testBasicAside() {
        Button button = new ButtonImpl();
        System.out.println(button);
    }

    @Test
    public void testAsideWithId() {
        Button button = new ButtonImpl();
        button.putAttribute("id","sidebar");
        System.out.println(button);
    }

    @Test
    public void testAsideWithClassName() {
        Button button = new ButtonImpl();
        button.putAttribute("className","sidebar-primary");
        System.out.println(button);
    }

    @Test
    public void testAsideWithAriaLabel() {
        Button button = new ButtonImpl();
        button.putAttribute("AriaLabel","Main sidebar");
        System.out.println(button);
    }

    @Test
    public void testAsideWithAllAttributes() {
        Button button = new ButtonImpl();
        button.putAttribute("id","sidebar");
        button.putAttribute("className","sidebar-primary");
        button.putAttribute("AriaLabel","Main sidebar");
        System.out.println(button);
    }

    @Test
    public void testAsideWithTextChild() {
        Button button = new ButtonImpl();
        PImpl paragraph = new PImpl();
        paragraph.setText("This is a sidebar content");
        button.addChild(paragraph);
        System.out.println(button);
    }

    @Test
    public void testAsideWithMultipleChildren() {
        Button button = new ButtonImpl();

        DivImpl div1 = new DivImpl();
        div1.setId("widget-1");

        DivImpl div2 = new DivImpl();
        div2.setClassName("widget");

        PImpl paragraph = new PImpl();
        paragraph.setText("Sidebar text content");

        button.addChild(div1);
        button.addChild(div2);
        button.addChild(paragraph);

        System.out.println(button);
    }

    @Test
    public void testAsideWithNestedChildren() {
        Button button = new ButtonImpl();
        button.putAttribute("AriaLabel","Main sidebar");
        DivImpl container = new DivImpl();
        container.setClassName("container");
        PImpl paragraph = new PImpl();
        paragraph.setText("Nested content");
        container.addChild(paragraph);
        button.addChild(container);
        System.out.println(button);
    }


}

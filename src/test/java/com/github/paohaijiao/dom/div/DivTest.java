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
package com.github.paohaijiao.dom.div;

import com.github.paohaijiao.dom.button.Button;
import com.github.paohaijiao.dom.button.impl.ButtonImpl;
import com.github.paohaijiao.dom.div.impl.DivImpl;
import com.github.paohaijiao.dom.p.impl.PImpl;
import com.github.paohaijiao.style.Style;
import org.junit.Test;

/**
 * packageName com.github.paohaijiao.dom.div
 *
 * @author Martin
 * @version 1.0.0
 * @since 2025/11/1
 */
public class DivTest {
    @Test
    public void div() {
        Div div = new DivImpl();
        System.out.println(div);
    }

    @Test
    public void div1() {
        Div div = new DivImpl();
        div.putAttribute("id","sidebar");
        System.out.println(div);
    }

    @Test
    public void testAsideWithClassName() {
        Div div = new DivImpl();
        div.putAttribute("className","sidebar-primary");
        System.out.println(div);
    }

    @Test
    public void testAsideWithAriaLabel() {
        Div div = new DivImpl();
        div.putAttribute("AriaLabel","Main sidebar");
        System.out.println(div);
    }

    @Test
    public void testAsideWithAllAttributes() {
        Div div = new DivImpl();
        div.putAttribute("id","sidebar");
        div.putAttribute("className","sidebar-primary");
        div.putAttribute("AriaLabel","Main sidebar");
        System.out.println(div);
    }

    @Test
    public void testAsideWithTextChild() {
        DivImpl div = new DivImpl();
        div.putStyle("height","100%");
        div.putStyle("width","100%");
        PImpl paragraph = new PImpl();
        paragraph.setText("This is a sidebar content");
        div.addChild(paragraph);
        System.out.println(div);
    }

}

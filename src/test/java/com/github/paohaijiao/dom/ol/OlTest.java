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
package com.github.paohaijiao.dom.ol;

import com.github.paohaijiao.dom.main.impl.MainImpl;
import com.github.paohaijiao.dom.ol.impl.OlImpl;
import com.github.paohaijiao.dom.p.impl.PImpl;
import org.junit.Test;

/**
 * packageName com.github.paohaijiao.dom.label
 *
 * @author Martin
 * @version 1.0.0
 * @since 2025/11/1
 */
public class OlTest {

    public static OlImpl h1 = new OlImpl();

    @Test
    public void div() {
        System.out.println(h1);
    }

    @Test
    public void div1() {
        h1.putAttribute("id","sidebar");
        System.out.println(h1);
    }

    @Test
    public void testAsideWithClassName() {
        h1.putAttribute("className","sidebar-primary");
        System.out.println(h1);
    }

    @Test
    public void testAsideWithAriaLabel() {
        h1.putAttribute("AriaLabel","Main sidebar");
        System.out.println(h1);
    }

    @Test
    public void testAsideWithAllAttributes() {
        h1.putAttribute("id","sidebar");
        h1.putAttribute("className","sidebar-primary");
        h1.putAttribute("AriaLabel","Main sidebar");
        System.out.println(h1);
    }

    @Test
    public void testAsideWithTextChild() {
        h1.putStyle("height","100%");
        h1.putStyle("width","100%");
        PImpl paragraph = new PImpl();
        paragraph.setText("This is a sidebar content");
        h1.addChild(paragraph);
        System.out.println(h1);
    }
}

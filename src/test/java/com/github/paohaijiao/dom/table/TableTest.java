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
package com.github.paohaijiao.dom.table;

import com.github.paohaijiao.dom.p.impl.PImpl;
import com.github.paohaijiao.dom.span.impl.SpanImpl;
import com.github.paohaijiao.dom.table.impl.TableImpl;
import com.github.paohaijiao.dom.td.Td;
import com.github.paohaijiao.dom.td.impl.TdImpl;
import com.github.paohaijiao.dom.th.Th;
import com.github.paohaijiao.dom.th.impl.ThImpl;
import com.github.paohaijiao.dom.thead.Thead;
import com.github.paohaijiao.dom.thead.impl.TheadImpl;
import com.github.paohaijiao.dom.tr.Tr;
import com.github.paohaijiao.dom.tr.impl.TrImpl;
import org.junit.Test;

/**
 * packageName com.github.paohaijiao.dom.label
 *
 * @author Martin
 * @version 1.0.0
 * @since 2025/11/1
 */
public class TableTest {

    public static TableImpl h1 = new TableImpl();

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
        Thead thead = new TheadImpl();
        thead.putAttribute("className","sidebar-primary");
        Tr th = new TrImpl();
        th.putAttribute("className","sidebar-primary");
        Td td = new TdImpl();
        td.putAttribute("className","sidebar-primary");
        th.addChild(td);
        Td td1 = new TdImpl();
        td1.putAttribute("className","sidebar-primary");
        th.addChild(td1);
        thead.addChild(th);
        h1.addChild(thead);
        System.out.println(h1);
    }
}

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
package com.github.paohaijiao.dom.body;

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.dom.a.impl.AImpl;
import com.github.paohaijiao.model.AttrModel;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * packageName com.github.paohaijiao.dom.body
 *
 * @author Martin
 * @version 1.0.0
 * @since 2025/10/31
 */
public class BodyImplTest {
    private BodyImpl body=new BodyImpl();
    @Test
    public void testAddElement() {
        AImpl a=new AImpl();
        body.addElement(a);
        System.out.println(body);
        List<Dom> children = body.getElements();
        System.out.println(children);
    }
    @Test
    public void testAttributes() {
        AImpl a=new AImpl();
        body.addElement(a);
        AttrModel attrModel=new AttrModel();
        attrModel.put("width","100%");
        attrModel.put("height","100%");
        body.setAttribute(attrModel);
        System.out.println(body);
        List<Dom> children = body.getElements();
        System.out.println(children);
    }
}

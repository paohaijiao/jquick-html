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
package com.github.paohaijiao.dom.meta;

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.dom.abs.AbsDom;
import com.github.paohaijiao.enums.DomEnums;
import com.github.paohaijiao.exception.JAssert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * packageName com.github.paohaijiao.dom.meta
 *
 * @author Martin
 * @version 1.0.0
 * @since 2025/11/1
 */
public class Meta extends AbsDom implements Dom {

    private HashMap<String,String> map=new HashMap<String,String> ();

    private final String nameKey="name";

    private final String contentKey="content";

    private final String charsetKey="charset";

    public String getName() {
        return map.get(nameKey);
    }

    public String getContent() {
        return map.get(contentKey);
    }

    public String getCharset() {
        return map.get(charsetKey);
    }
    public void setName(String name) {
         map.put(nameKey,name);
    }

    public void  setContent(String content) {
         map.put(contentKey,content);
    }

    public void setCharset(String charset) {
         map.put(charsetKey,charset);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" <").append(this.getNodeType());
        if(null!=getName()){
            sb.append(" name=\"").append(getName()).append("\"");
        }
        if(null!=getCharset()){
            sb.append(" charset=\"").append(getCharset()).append("\"");
        }
        if(null!=getContent()){
            sb.append(" content=\"").append(getContent()).append("\"");
        }
        sb.append(this.getNodeType()).append("> ");
        return prettyPrint(sb.toString());
    }

    @Override
    public void addChild(Dom child) {
        JAssert.throwNewException("not support addChild");
    }

    @Override
    public List<Dom> getChildren() {
        return new ArrayList<>();
    }

    @Override
    public String getNodeType() {
        return DomEnums.meta.getCode();
    }
}

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
package com.github.paohaijiao.dom.script;

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.dom.abs.AbsDom;
import com.github.paohaijiao.enums.DomEnums;
import com.github.paohaijiao.exception.JAssert;
import org.apache.commons.lang3.StringUtils;

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
public class Script extends AbsDom implements Dom {

    private HashMap<String,String> map=new HashMap<String,String> ();

    private String text;

    private final String hrefKey="href";

    private final String relKey="rel";

    private final String srcKey="src";


    public String getHref() {
        return map.get(hrefKey);
    }

    public String getRel() {
        return map.get(relKey);
    }


    public String getSrc() {
        return map.get(srcKey);
    }

    public void setHref(String href) {
         map.put(hrefKey,href);
    }

    public void  setRel(String rel) {
         map.put(relKey,rel);
    }

    public void setSrc(String src) {
        map.put(srcKey,src);
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" <").append(this.getNodeType());
        if(null!=getHref()){
            sb.append(" href=\"").append(getHref()).append("\"");
        }
        if(null!=getRel()){
            sb.append(" rel=\"").append(getRel()).append("\"");
        }
        if(null!=getSrc()){
            sb.append(" src=\"").append(getSrc()).append("\"");
        }
        if(!StringUtils.isEmpty(text)){
            sb.append(text);
        }
        sb.append(">");
        sb.append("</").append(this.getNodeType()).append(">");
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
        return DomEnums.script.getCode();
    }
}

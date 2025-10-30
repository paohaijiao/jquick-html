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
package com.github.paohaijiao.layout.params;

import com.github.paohaijiao.model.AttrModel;

import java.util.HashMap;

/**
 * packageName com.github.paohaijiao.layout.params
 *
 * @author Martin
 * @version 1.0.0
 * @since 2025/10/30
 */
public class LayoutParams extends HashMap<String, String> {


    /**
     * 添加参数
     */
    public LayoutParams add(String key, String value) {
        super.put(key, value);
        return this;
    }

    /**
     * 获取参数
     */
    public String get(String key) {
        return super.get(key);
    }

    /**
     * 转换为HTML样式属性（用于生成style）
     */
    public String toStyle() {
        StringBuilder style = new StringBuilder();
        super.forEach((k, v) -> style.append(k).append(":").append(v).append(";"));
        return style.toString();
    }

    /**
     * 转换为属性模型（用于DOM元素的属性设置）
     */
    public AttrModel toAttrModel() {
        AttrModel attr = new AttrModel();
//        super.forEach(attr::add);
        return attr;
    }
}

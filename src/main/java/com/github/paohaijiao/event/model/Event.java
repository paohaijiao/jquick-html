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
package com.github.paohaijiao.event.model;

import com.github.paohaijiao.common.Dom;

import java.util.HashMap;
import java.util.Map;

/**
 * packageName com.github.paohaijiao.event.model
 *
 * @author Martin
 * @version 1.0.0
 * @since 2025/10/30
 */
public class Event {
    /**
     * 事件类型
     */
    private final String type;
    /**
     * 事件源（触发事件的DOM元素）
     */
    private final Dom source;
    /**
     *  事件触发时间戳
     */
    private final long timestamp;
    /**
     * 事件附加参数
     */
    private final Map<String, Object> params;

    public Event(String type, Dom source) {
        this.type = type;
        this.source = source;
        this.timestamp = System.currentTimeMillis();
        this.params = new HashMap<>();
    }

    public void addParam(String key, Object value) {
        params.put(key, value);
    }

    public Object getParam(String key) {
        return params.get(key);
    }

    public String getType() {
        return type;
    }

    public Dom getSource() {
        return source;
    }

    public long getTimestamp() {
        return timestamp;
    }
}

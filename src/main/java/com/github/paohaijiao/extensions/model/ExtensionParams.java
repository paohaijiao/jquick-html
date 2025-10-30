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
package com.github.paohaijiao.extensions.model;


import java.util.HashMap;
import java.util.Map;

/**
 * 扩展参数：传递给扩展的输入参数
 */
public class ExtensionParams {

    private final Map<String, Object> params = new HashMap<>();

    public static ExtensionParams create() {
        return new ExtensionParams();
    }

    public ExtensionParams addParam(String key, Object value) {
        params.put(key, value);
        return this;
    }

    public Object getParam(String key) {
        return params.get(key);
    }

    public <T> T getParam(String key, Class<T> type) {
        Object value = params.get(key);
        return type.isInstance(value) ? type.cast(value) : null;
    }

    public Map<String, Object> getParams() {
        return new HashMap<>(params); // 返回副本，防止外部修改
    }
}

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
package com.github.paohaijiao.extensions;

import com.github.paohaijiao.context.Context;
import com.github.paohaijiao.extensions.model.ExtensionParams;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 扩展管理器：管理所有注册的扩展，协调扩展的生命周期
 */
public class ExtensionManager {
    private final Map<String, Extension> extensions = new HashMap<>();
    private final Context context;

    public ExtensionManager(Context context) {
        this.context = context;
    }

    /**
     * 注册扩展（自动执行初始化）
     *
     * @param extension 扩展实例
     */
    public void registerExtension(Extension extension) {
        if (extension == null) {
            throw new IllegalArgumentException("Extension cannot be null");
        }
        String extensionId = extension.getExtensionId();
        if (extensions.containsKey(extensionId)) {
            throw new IllegalStateException("Extension with id '" + extensionId + "' already exists");
        }
        // 注册并初始化
        extensions.put(extensionId, extension);
        extension.initialize(context);
    }

    /**
     * 根据ID获取扩展
     */
    public Extension getExtension(String extensionId) {
        return extensions.get(extensionId);
    }

    /**
     * 获取所有扩展ID
     */
    public Set<String> getExtensionIds() {
        return extensions.keySet();
    }

    /**
     * 执行指定扩展
     *
     * @param extensionId 扩展ID
     * @param params      扩展参数
     * @return 扩展执行结果
     */
    public Object executeExtension(String extensionId, ExtensionParams params) {
        Extension extension = getExtension(extensionId);
        if (extension == null) {
            throw new IllegalArgumentException("Extension '" + extensionId + "' not found");
        }
        return extension.execute(context, params != null ? params : ExtensionParams.create());
    }

    /**
     * 销毁所有扩展（释放资源）
     */
    public void destroyAll() {
        extensions.values().forEach(Extension::destroy);
        extensions.clear();
    }
}
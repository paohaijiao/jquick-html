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
package com.github.paohaijiao.script;

import com.github.paohaijiao.script.impl.ExternalScript;
import com.github.paohaijiao.script.impl.InlineScript;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 脚本管理器：管理页面中所有脚本，处理加载顺序和依赖关系
 */
public class ScriptManager {
    /**
     * 外部脚本列表（按添加顺序存储）
     */
    private final List<ExternalScript> externalScripts = new ArrayList<>();
    /**
     * 内联脚本列表（按添加顺序存储）
     */
    private final List<InlineScript> inlineScripts = new ArrayList<>();

    /**
     * 添加外部脚本
     */
    public void addExternalScript(ExternalScript script) {
        if (script != null && !externalScripts.contains(script)) {
            externalScripts.add(script);
        }
    }

    /**
     * 添加内联脚本
     */
    public void addInlineScript(InlineScript script) {
        if (script != null && !inlineScripts.contains(script)) {
            inlineScripts.add(script);
        }
    }

    /**
     * 创建并添加外部脚本（简化接口）
     */
    public ExternalScript addExternalScript(String src) {
        ExternalScript script = new ExternalScript(src);
        addExternalScript(script);
        return script;
    }

    /**
     * 创建并添加内联脚本（简化接口）
     */
    public InlineScript addInlineScript(String code) {
        InlineScript script = new InlineScript(code);
        addInlineScript(script);
        return script;
    }

    /**
     * 按加载策略排序外部脚本：
     * - 同步脚本（NONE）优先于异步（ASYNC）和延迟（DEFER）
     * - 延迟脚本（DEFER）按添加顺序排列（保证执行顺序）
     */
    public List<ExternalScript> getSortedExternalScripts() {

        List<ExternalScript> syncScripts = externalScripts.stream()
                .filter(s -> s.getLoadStrategy() == Script.LoadStrategy.NONE)
                .collect(Collectors.toList()); // 同步脚本（无策略）

        List<ExternalScript> deferScripts = externalScripts.stream()
                .filter(s -> s.getLoadStrategy() == Script.LoadStrategy.DEFER)
                .collect(Collectors.toList());    // 延迟脚本（DEFER）

        List<ExternalScript> asyncScripts = externalScripts.stream()
                .filter(s -> s.getLoadStrategy() == Script.LoadStrategy.ASYNC)
                .collect(Collectors.toList());        // 异步脚本（ASYNC）（执行顺序不保证，按添加顺序）

        // 合并：同步 -> 延迟 -> 异步
        List<ExternalScript> sorted = new ArrayList<>();
        sorted.addAll(syncScripts);
        sorted.addAll(deferScripts);
        sorted.addAll(asyncScripts);
        return sorted;
    }

    /**
     * 生成所有脚本的HTML字符串（按合理顺序排列）
     */
    public String renderAllScripts() {
        StringBuilder sb = new StringBuilder();
        for (ExternalScript script : getSortedExternalScripts()) {// 外部脚本（按排序后输出）
            sb.append(script.toString()).append("\n");
        }
        for (InlineScript script : inlineScripts) { // 内联脚本（按添加顺序输出，通常放在外部脚本之后）
            sb.append(script.toString()).append("\n");
        }
        return sb.toString().trim(); // 去除末尾空行
    }

    /**
     * 清除所有脚本
     */
    public void clear() {
        externalScripts.clear();
        inlineScripts.clear();
    }
}

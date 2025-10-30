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
package com.github.paohaijiao.layout.manage;

import com.github.paohaijiao.layout.Layout;
import com.github.paohaijiao.layout.impl.FlexLayout;
import com.github.paohaijiao.layout.impl.FlowLayout;
import com.github.paohaijiao.layout.impl.GridLayout;

import java.util.HashMap;
import java.util.Map;

/**
 * 布局管理器：管理多个布局实例，支持布局切换和全局配置
 */
public class LayoutManager {

    private final Map<String, Layout> layouts = new HashMap<>();

    private String defaultLayoutType = "flow";

    /**
     * 注册布局
     */
    public void registerLayout(String layoutId, Layout layout) {
        layouts.put(layoutId, layout);
    }

    /**
     * 获取布局
     */
    public Layout getLayout(String layoutId) {
        return layouts.get(layoutId);
    }

    /**
     * 创建默认布局（根据类型自动实例化）
     */
    public Layout createDefaultLayout() {
        switch (defaultLayoutType) {
            case "grid":
                return new GridLayout();
            case "flex":
                return new FlexLayout();
            default:
                return new FlowLayout();
        }
    }

    /**
     * 切换布局类型（全局默认）
     */
    public void setDefaultLayoutType(String type) {
        this.defaultLayoutType = type;
    }
}
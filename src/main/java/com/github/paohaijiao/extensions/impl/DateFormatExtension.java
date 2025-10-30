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
package com.github.paohaijiao.extensions.impl;


import com.github.paohaijiao.context.Context;
import com.github.paohaijiao.extensions.Extension;
import com.github.paohaijiao.extensions.model.ExtensionParams;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 数据过滤扩展：格式化日期
 */
public class DateFormatExtension implements Extension {

    private SimpleDateFormat dateFormat;

    @Override
    public String getExtensionId() {
        return "date-format";
    }

    @Override
    public String getName() {
        return "日期格式化";
    }

    @Override
    public void initialize(Context context) {
        // 初始化默认格式
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("日期格式化扩展初始化完成");
    }

    @Override
    public Object execute(Context context, ExtensionParams params) {
        Date date = params.getParam("date", Date.class);
        String pattern = params.getParam("pattern", String.class);

        if (date == null) {
            return null;
        }
        if (pattern != null && !pattern.isEmpty()) {
            try {
                return new SimpleDateFormat(pattern).format(date);
            } catch (Exception e) {
                return dateFormat.format(date);
            }
        }
        return dateFormat.format(date);
    }

    @Override
    public void destroy() {
        dateFormat = null; // 释放资源
        System.out.println("日期格式化扩展已销毁");
    }
}

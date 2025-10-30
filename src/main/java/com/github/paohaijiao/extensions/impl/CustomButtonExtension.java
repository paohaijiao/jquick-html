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
import com.github.paohaijiao.dom.button.impl.ButtonImpl;
import com.github.paohaijiao.extensions.Extension;
import com.github.paohaijiao.extensions.model.ExtensionParams;

/**
 * 自定义标签扩展：生成<my-button>标签
 */
public class CustomButtonExtension implements Extension {

    @Override
    public String getExtensionId() {
        return "custom-button";
    }

    @Override
    public String getName() {
        return "自定义按钮标签";
    }

    @Override
    public void initialize(Context context) {
        // 初始化：注册标签解析器（示例逻辑）
        System.out.println("自定义按钮扩展初始化完成");
    }

    @Override
    public Object execute(Context context, ExtensionParams params) {
        // 从参数中获取按钮文本和样式
        String text = params.getParam("text", String.class);
        String style = params.getParam("style", String.class);
        ButtonImpl button = new ButtonImpl();
        // 创建自定义按钮元素
//        HtmlElementImpl button = new HtmlElementImpl("my-button");
//        button.setAttribute(new AttrModel()
//                .add("text", text != null ? text : "默认按钮")
//                .add("style", style != null ? style : "padding: 8px 16px;"));

        // 添加到上下文
//        context.addElement(button);
        return button; // 返回生成的元素
    }

    @Override
    public void destroy() {
        System.out.println("自定义按钮扩展已销毁");
    }
}

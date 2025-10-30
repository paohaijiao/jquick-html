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
package com.github.paohaijiao.extension;

import com.github.paohaijiao.context.Context;
import com.github.paohaijiao.context.impl.PageContext;
import com.github.paohaijiao.extensions.impl.CustomButtonExtension;
import com.github.paohaijiao.extensions.impl.DateFormatExtension;
import com.github.paohaijiao.extensions.model.ExtensionParams;
import org.junit.Test;

import java.util.Date;

/**
 * packageName com.github.paohaijiao.extension
 *
 * @author Martin
 * @version 1.0.0
 * @since 2025/10/30
 */
public class ExtensionTest {
    @Test
    public void document() {
        Context context = new PageContext();
        ((PageContext) context).registerExtension(new CustomButtonExtension());
        ((PageContext) context).registerExtension(new DateFormatExtension());
        Object button = ((PageContext) context).executeExtension("custom-button", ExtensionParams.create().addParam("text", "扩展按钮").addParam("style", "background: blue; color: white;"));
        System.out.println("生成的按钮元素：" + button);
        Object formattedDate = ((PageContext) context).executeExtension("date-format", ExtensionParams.create().addParam("date", new Date()).addParam("pattern", "yyyy年MM月dd日"));
        System.out.println("格式化后的日期：" + formattedDate);
        context.clear();
    }
}

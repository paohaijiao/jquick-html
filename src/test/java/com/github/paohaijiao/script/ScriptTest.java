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
import org.junit.Test;

/**
 * packageName com.github.paohaijiao.script
 *
 * @author Martin
 * @version 1.0.0
 * @since 2025/10/30
 */
public class ScriptTest {
    @Test
    public void document() {
        ScriptManager scriptManager = new ScriptManager();
        ExternalScript jquery = scriptManager.addExternalScript("https://code.jquery.com/jquery-3.6.0.min.js");
        jquery.setLoadStrategy(Script.LoadStrategy.DEFER); // 延迟加载
        jquery.addAttribute("crossorigin", "anonymous");
        InlineScript appScript = scriptManager.addInlineScript(
                "// 初始化代码\n" +
                        "$(document).ready(function() {\n" +
                        "  console.log('页面加载完成');\n" +
                        "});"
        );
        //  appScript.setAttribute(new AttrModel().add("type", "text/javascript"));
        String scriptsHtml = scriptManager.renderAllScripts();
        System.out.println(scriptsHtml);
    }
}

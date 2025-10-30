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
package com.github.paohaijiao.session;

import com.github.paohaijiao.script.Script;
import com.github.paohaijiao.script.ScriptManager;
import com.github.paohaijiao.script.impl.ExternalScript;
import com.github.paohaijiao.script.impl.InlineScript;
import com.github.paohaijiao.session.impl.InMemorySessionManager;
import org.junit.Test;

/**
 * packageName com.github.paohaijiao.session
 *
 * @author Martin
 * @version 1.0.0
 * @since 2025/10/30
 */
public class SessionTest {
    @Test
    public void document() throws InterruptedException {
        SessionManager sessionManager = new InMemorySessionManager();
        Session userASession = sessionManager.createSession();
        userASession.setAttribute("username", "Alice");
        userASession.setAttribute("role", "admin");
        System.out.println("用户A会话ID：" + userASession.getId());
        System.out.println("用户A角色：" + userASession.getAttribute("role"));
        String sessionId = userASession.getId();
        Session retrievedSession = sessionManager.getSession(sessionId);
        System.out.println("获取到的用户名：" + retrievedSession.getAttribute("username"));
        retrievedSession.setMaxInactiveInterval(1);
        System.out.println("会话超时时间：" + retrievedSession.getMaxInactiveInterval() + "秒");
        Thread.sleep(2000);
        Session expiredSession = sessionManager.getSession(sessionId);
        System.out.println("会话是否有效：" + (expiredSession != null ? "是" : "否")); // 应输出"否"
        System.out.println("活跃会话数量：" + sessionManager.getActiveSessionCount());
    }
}

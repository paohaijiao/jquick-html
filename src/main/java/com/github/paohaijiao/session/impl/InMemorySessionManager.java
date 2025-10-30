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
package com.github.paohaijiao.session.impl;

import com.github.paohaijiao.session.Session;
import com.github.paohaijiao.session.SessionManager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 内存会话管理器：管理InMemorySession，定期清理过期会话
 */
public class InMemorySessionManager implements SessionManager {
    /**
     * key=会话ID，value=会话实例
     */
    private final Map<String, Session> sessions = new ConcurrentHashMap<>();
    /**
     * 定时任务：定期清理过期会话（每5分钟执行一次）
     */
    private final ScheduledExecutorService cleaner = Executors.newSingleThreadScheduledExecutor();

    public InMemorySessionManager() {
        /**
         *  初始化定时清理任务
         */
        cleaner.scheduleAtFixedRate(
                this::cleanExpiredSessions,
                5, // 首次执行延迟5分钟
                5, // 之后每5分钟执行一次
                TimeUnit.MINUTES
        );
    }

    @Override
    public Session createSession() {
        Session session = new InMemorySession();
        sessions.put(session.getId(), session);
        return session;
    }

    @Override
    public Session getSession(String sessionId) {
        if (sessionId == null) {
            return null;
        }
        Session session = sessions.get(sessionId);
        // 检查会话是否有效（已过期则移除）
        if (session != null && !session.isValid()) {
            sessions.remove(sessionId);
            return null;
        }
        return session;
    }

    @Override
    public void removeSession(String sessionId) {
        if (sessionId != null) {
            Session session = sessions.remove(sessionId);
            if (session != null) {
                session.invalidate(); // 主动销毁会话
            }
        }
    }

    @Override
    public void cleanExpiredSessions() {
        // 遍历所有会话，移除过期的会话
        sessions.entrySet().removeIf(entry -> {
            Session session = entry.getValue();
            return !session.isValid();
        });
    }

    @Override
    public int getActiveSessionCount() {
        return sessions.size();
    }

    /**
     * 关闭管理器（停止定时任务）
     */
    public void shutdown() {
        cleaner.shutdown();
    }
}
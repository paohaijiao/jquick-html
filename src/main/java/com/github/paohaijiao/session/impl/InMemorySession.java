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

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * 内存会话实现：会话数据存储在内存中，适合开发环境
 */
public class InMemorySession implements Session {

    /**
     * 会话唯一标识（UUID生成）
     */
    private final String id;

    private final Map<String, Object> attributes = new HashMap<>();

    private final long creationTime;

    private long lastAccessedTime;

    private int maxInactiveInterval = 1800;

    private boolean valid = true;

    public InMemorySession() {
        this.id = generateSessionId();
        this.creationTime = System.currentTimeMillis();
        this.lastAccessedTime = creationTime;
    }

    /**
     * 生成会话ID（UUID去除横线，缩短长度）
     */
    private String generateSessionId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setAttribute(String key, Object value) {
        if (!valid) {
            throw new IllegalStateException("Session is invalid");
        }
        attributes.put(key, value);
        refresh(); // 更新访问时间
    }

    @Override
    public Object getAttribute(String key) {
        if (!isValid()) {
            return null;
        }
        refresh(); // 更新访问时间
        return attributes.get(key);
    }

    @Override
    public Object removeAttribute(String key) {
        if (!valid) {
            throw new IllegalStateException("Session is invalid");
        }
        Object removed = attributes.remove(key);
        refresh(); // 更新访问时间
        return removed;
    }

    @Override
    public Set<String> getAttributeNames() {
        return attributes.keySet();
    }

    @Override
    public long getCreationTime() {
        return creationTime;
    }

    @Override
    public long getLastAccessedTime() {
        return lastAccessedTime;
    }

    @Override
    public int getMaxInactiveInterval() {
        return maxInactiveInterval;
    }

    @Override
    public void setMaxInactiveInterval(int timeout) {
        this.maxInactiveInterval = timeout;
    }

    @Override
    public void invalidate() {
        valid = false;
        attributes.clear(); // 清除所有属性
    }

    @Override
    public boolean isValid() {
        if (!valid) {
            return false;
        }
        // 检查是否过期（永不超时的会话maxInactiveInterval为-1）
        if (maxInactiveInterval == -1) {
            return true;
        }
        long inactiveTime = System.currentTimeMillis() - lastAccessedTime;
        return inactiveTime < (maxInactiveInterval * 1000L);
    }

    @Override
    public void refresh() {
        if (valid) {
            lastAccessedTime = System.currentTimeMillis();
        }
    }
}
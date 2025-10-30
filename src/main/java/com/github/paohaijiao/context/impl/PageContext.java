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
package com.github.paohaijiao.context.impl;

import com.github.paohaijiao.common.Document;
import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.context.Context;
import com.github.paohaijiao.dom.document.DocumentImpl;
import com.github.paohaijiao.event.handler.EventHandler;
import com.github.paohaijiao.event.manager.EventManager;
import com.github.paohaijiao.event.model.Event;
import com.github.paohaijiao.layout.Layout;
import com.github.paohaijiao.layout.impl.FlowLayout;
import com.github.paohaijiao.script.Script;
import com.github.paohaijiao.script.ScriptManager;
import com.github.paohaijiao.script.impl.ExternalScript;
import com.github.paohaijiao.script.impl.InlineScript;
import com.github.paohaijiao.session.Session;
import com.github.paohaijiao.session.SessionManager;
import com.github.paohaijiao.session.impl.InMemorySessionManager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 页面上下文实现类，整合元素、事件、脚本、会话等核心组件
 */
public class PageContext implements Context {


    private final Document document = new DocumentImpl();
    private final List<Dom> elements = new ArrayList<>();
    private final EventManager eventManager = new EventManager();
    private final ScriptManager scriptManager = new ScriptManager();
    private final SessionManager sessionManager = new InMemorySessionManager(); // 会话管理器
    private Layout layout = new FlowLayout();
    private Session currentSession;

    @Override
    public void addElement(Dom element) {
        if (element != null) {
            elements.add(element);
            // 同时添加到文档的body中（默认行为）
            if (document.getBody() != null) {
                document.getBody().addChild(element);
            }
        }
    }

    @Override
    public List<Dom> getElementsByType(String nodeType) {
        return elements.stream()
                .filter(element -> nodeType.equals(element.getNodeType()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Dom> getAllElements() {
        return new ArrayList<>(elements); // 返回不可修改副本
    }

    @Override
    public Layout getLayout() {
        return layout;
    }

    @Override
    public void setLayout(Layout layout) {
        this.layout = layout != null ? layout : new FlowLayout();
    }

    @Override
    public void addEventHandler(Dom element, EventHandler handler) {
        eventManager.addEventHandler(element, handler);
    }

    @Override
    public void removeEventHandler(Dom element, EventHandler handler) {
        eventManager.removeEventHandler(element, handler);
    }

    @Override
    public void triggerEvent(Dom element, String eventType) {
        Event event = new Event(eventType, element);
        eventManager.triggerEvent(element, event);
    }

    // ------------------------------ 脚本管理 ------------------------------
    @Override
    public void addScript(Script script) {
        if (script == null) return;
        if (script.getScriptType().equals("external")) {
            scriptManager.addExternalScript((ExternalScript) script);
        } else if (script.getScriptType().equals("inline")) {
            scriptManager.addInlineScript((InlineScript) script);
        }
        if (document.getHead() != null) {
            document.getHead().addChild(script);
        }
    }

    @Override
    public List<Script> getAllScripts() {
        List<Script> scripts = new ArrayList<>();
        // 整合外部脚本和内联脚本
        scriptManager.getSortedExternalScripts().forEach(scripts::add);
        //   scriptManager.getInlineScripts().forEach(scripts::add); // 假设ScriptManager有getInlineScripts方法
        return scripts;
    }

    @Override
    public String renderScripts() {
        return scriptManager.renderAllScripts();
    }

    @Override
    public Session getSession() {
        if (currentSession == null || !currentSession.isValid()) {
            currentSession = sessionManager.createSession(); // 不存在或过期则创建新会话
        }
        return currentSession;
    }

    @Override
    public Session getSession(String sessionId) {
        return sessionManager.getSession(sessionId);
    }

    @Override
    public void invalidateSession() {
        if (currentSession != null) {
            sessionManager.removeSession(currentSession.getId());
            currentSession = null;
        }
    }

    @Override
    public String renderHtml() {
        // 1. 应用布局（计算元素位置）
        // 假设容器宽高为1000x800（实际可从请求中获取）
        layout.layout(1000, 800);

        // 2. 生成完整HTML文档
        return document.toString();
    }

    @Override
    public void clear() {
        elements.clear();
        //eventManager.clear();
        scriptManager.clear();
        if (currentSession != null) {
            invalidateSession();
        }
    }

    public Document getDocument() {
        return document;
    }
}

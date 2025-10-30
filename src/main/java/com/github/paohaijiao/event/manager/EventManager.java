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
package com.github.paohaijiao.event.manager;

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.event.handler.EventHandler;
import com.github.paohaijiao.event.model.Event;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

/**
 * 事件管理器，负责DOM元素与事件处理器的绑定
 */
public class EventManager {


    private final Map<Dom, Map<String, List<EventHandler>>> elementEvents = new HashMap<>();

    /**
     * 为元素绑定事件处理器
     * @param element 目标DOM元素
     * @param handler 事件处理器
     */
    public void addEventHandler(Dom element, EventHandler handler) {
        if (element == null || handler == null) {
            return;
        }
        Map<String, List<EventHandler>> events = elementEvents.computeIfAbsent(element, k -> new HashMap<>());
        List<EventHandler> handlers = events.computeIfAbsent(handler.getEventType(), k -> new ArrayList<>());
        handlers.add(handler);
    }

    /**
     * 移除元素的指定事件处理器
     * @param element 目标DOM元素
     * @param handler 要移除的事件处理器
     */
    public void removeEventHandler(Dom element, EventHandler handler) {
        if (element == null || handler == null) {
            return;
        }
        Map<String, List<EventHandler>> events = elementEvents.get(element);
        if (events == null) {
            return;
        }
        List<EventHandler> handlers = events.get(handler.getEventType());
        if (handlers != null) {
            handlers.remove(handler);
            if (handlers.isEmpty()) {
                events.remove(handler.getEventType());
            }
            if (events.isEmpty()) {
                elementEvents.remove(element);
            }
        }
    }

    /**
     * 触发元素的指定事件
     * @param element 目标DOM元素
     * @param event 事件对象
     */
    public void triggerEvent(Dom element, Event event) {
        if (element == null || event == null) {
            return;
        }
        Map<String, List<EventHandler>> events = elementEvents.get(element);
        if (events == null) {
            return;
        }
        List<EventHandler> handlers = events.get(event.getType());
        if (handlers != null) {
            for (EventHandler handler : new ArrayList<>(handlers)) {
                handler.handle(event);
            }
        }
    }
}

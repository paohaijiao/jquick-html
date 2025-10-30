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
package com.github.paohaijiao.event.handler.impl;



import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.event.handler.EventHandler;
import com.github.paohaijiao.event.model.Event;

/**
 * 双击事件处理器（对应 ondblclick）
 */
public class DoubleClickEventHandler implements EventHandler {

    @FunctionalInterface
    public interface DoubleClickHandler {
        void onDoubleClick(Dom source, Event event);
    }

    private final DoubleClickHandler handler;

    public DoubleClickEventHandler(DoubleClickHandler handler) {
        this.handler = handler;
    }

    @Override
    public String getEventType() {
        return "dblclick"; // 对应HTML的ondblclick事件
    }

    @Override
    public void handle(Event event) {
        if (handler != null) {
            handler.onDoubleClick(event.getSource(), event);
        }
    }
}

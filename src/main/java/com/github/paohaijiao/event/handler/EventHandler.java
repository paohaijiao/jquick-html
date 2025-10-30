package com.github.paohaijiao.event.handler;

import com.github.paohaijiao.event.model.Event;

public interface EventHandler {
    /**
     * 获取事件类型（如 "click"、"dblclick"）
     * @return 事件类型字符串
     */
    String getEventType();

    /**
     * 执行事件处理逻辑
     * @param event 事件对象，包含事件相关信息（如触发元素、事件参数等）
     */
    void handle(Event event);
}

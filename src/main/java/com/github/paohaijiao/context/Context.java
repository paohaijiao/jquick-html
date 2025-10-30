package com.github.paohaijiao.context;


import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.event.handler.EventHandler;
import com.github.paohaijiao.layout.Layout;
import com.github.paohaijiao.script.Script;
import com.github.paohaijiao.session.Session;

import java.util.List;

/**
 * 页面上下文接口，统一管理HTML元素、事件、脚本、会话等组件
 */
public interface Context {

    /**
     * 添加DOM元素到上下文（如body、div等）
     */
    void addElement(Dom element);

    /**
     * 根据元素类型获取所有元素
     *
     * @param nodeType 元素类型（如"div"、"p"）
     */
    List<Dom> getElementsByType(String nodeType);

    /**
     * 获取页面中所有元素
     */
    List<Dom> getAllElements();

    /**
     * 获取当前布局
     */
    Layout getLayout();

    /**
     * 为上下文设置全局布局
     */
    void setLayout(Layout layout);

    /**
     * 为元素绑定事件处理器
     */
    void addEventHandler(Dom element, EventHandler handler);

    /**
     * 移除元素的事件处理器
     */
    void removeEventHandler(Dom element, EventHandler handler);

    /**
     * 触发元素的指定事件
     *
     * @param element   目标元素
     * @param eventType 事件类型（如"click"）
     */
    void triggerEvent(Dom element, String eventType);

    /**
     * 添加脚本（外部或内联）
     */
    void addScript(Script script);

    /**
     * 获取所有脚本
     */
    List<Script> getAllScripts();

    /**
     * 渲染所有脚本为HTML字符串
     */
    String renderScripts();

    /**
     * 获取当前会话（不存在则创建）
     */
    Session getSession();

    /**
     * 根据会话ID获取会话
     */
    Session getSession(String sessionId);

    /**
     * 销毁当前会话
     */
    void invalidateSession();

    /**
     * 生成完整的HTML文档字符串（整合所有元素、布局、脚本等）
     */
    String renderHtml();

    /**
     * 清理上下文资源（元素、事件、会话等）
     */
    void clear();
}

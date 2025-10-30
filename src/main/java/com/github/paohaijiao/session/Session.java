package com.github.paohaijiao.session;

import java.util.Set;

/**
 * 会话接口，定义用户会话的核心能力
 */
public interface Session {

    /**
     * 获取会话唯一标识（如JSESSIONID）
     */
    String getId();

    /**
     * 设置会话属性（键值对）
     *
     * @param key   属性键
     * @param value 属性值（支持任意可序列化对象）
     */
    void setAttribute(String key, Object value);

    /**
     * 获取会话属性
     *
     * @param key 属性键
     * @return 属性值（无此键则返回null）
     */
    Object getAttribute(String key);

    /**
     * 移除会话属性
     *
     * @param key 属性键
     * @return 被移除的属性值
     */
    Object removeAttribute(String key);

    /**
     * 获取所有属性键
     */
    Set<String> getAttributeNames();

    /**
     * 获取会话创建时间（毫秒时间戳）
     */
    long getCreationTime();

    /**
     * 获取最后一次访问时间（毫秒时间戳）
     */
    long getLastAccessedTime();

    /**
     * 获取会话超时时间（秒）
     */
    int getMaxInactiveInterval();

    /**
     * 设置会话超时时间（秒）
     *
     * @param timeout 超时时间（-1表示永不超时）
     */
    void setMaxInactiveInterval(int timeout);

    /**
     * 销毁会话（清除所有属性，标记为无效）
     */
    void invalidate();

    /**
     * 检查会话是否有效（未过期且未被销毁）
     */
    boolean isValid();

    /**
     * 刷新会话访问时间（更新最后访问时间为当前时间）
     */
    void refresh();
}
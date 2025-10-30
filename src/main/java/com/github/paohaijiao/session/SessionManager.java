package com.github.paohaijiao.session;

/**
 * 会话管理器接口，负责会话的创建、查找和生命周期管理
 */
public interface SessionManager {

    /**
     * 创建新会话
     *
     * @return 新会话实例
     */
    Session createSession();

    /**
     * 根据会话ID查找会话
     *
     * @param sessionId 会话标识
     * @return 会话实例（不存在或已过期则返回null）
     */
    Session getSession(String sessionId);

    /**
     * 移除会话（主动销毁）
     *
     * @param sessionId 会话标识
     */
    void removeSession(String sessionId);

    /**
     * 清理所有过期会话（定期调用）
     */
    void cleanExpiredSessions();

    /**
     * 获取当前活跃会话数量
     */
    int getActiveSessionCount();
}

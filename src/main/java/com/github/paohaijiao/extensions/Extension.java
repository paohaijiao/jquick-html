package com.github.paohaijiao.extensions;
import com.github.paohaijiao.context.Context;
import com.github.paohaijiao.extensions.model.ExtensionParams;

/**
 * 扩展接口：所有扩展（插件）需实现此接口
 */
public interface Extension {

    /**
     * 扩展唯一标识（如"custom-tag"、"data-filter"）
     */
    String getExtensionId();

    /**
     * 扩展名称（用于展示）
     */
    String getName();

    /**
     * 扩展初始化（在上下文启动时执行）
     *
     * @param context 页面上下文，提供扩展所需的环境
     */
    void initialize(Context context);

    /**
     * 扩展执行逻辑（根据扩展类型执行具体功能）
     *
     * @param context 页面上下文
     * @param params  扩展参数（键值对）
     * @return 执行结果（可为null）
     */
    Object execute(Context context, ExtensionParams params);

    /**
     * 扩展销毁（在上下文关闭时执行，释放资源）
     */
    void destroy();
}
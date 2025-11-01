package com.github.paohaijiao.script;


import com.github.paohaijiao.common.Dom;

/**
 * 脚本接口，定义JavaScript脚本的核心能力
 */
public interface Script  {

    /**
     * 脚本类型（如"external"外部脚本、"inline"内联脚本）
     */
    String getScriptType();

    /**
     * 获取脚本内容
     */
    String getContent();

    /**
     * 设置脚本内容（内联脚本为代码字符串，外部脚本为src路径）
     */
    void setContent(String content);

    /**
     * 获取脚本加载策略
     */
    LoadStrategy getLoadStrategy();

    /**
     * 设置脚本加载策略（如async/defer）
     */
    void setLoadStrategy(LoadStrategy strategy);

    /**
     * 获取加载完成回调
     */
    String getOnLoad();

    /**
     * 脚本加载完成后执行的回调
     */
    void setOnLoad(String handler);

    /**
     * 转换为HTML中的<script>标签字符串
     */
    @Override
    String toString();

    /**
     * 脚本加载策略枚举（对应HTML5的async/defer属性）
     */
    enum LoadStrategy {
        /**
         * 无策略（默认同步加载）
         */
        NONE(""),
        /**
         * 异步加载（加载完成后立即执行）
         */
        ASYNC("async"),
        /**
         * 延迟加载（DOM解析完成后执行）
         */
        DEFER("defer");

        private final String attribute;

        LoadStrategy(String attribute) {
            this.attribute = attribute;
        }

        public String getAttribute() {
            return attribute;
        }
    }
}

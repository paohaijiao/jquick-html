package com.github.paohaijiao.layout;

import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.layout.params.LayoutParams;

import java.util.List;

public interface Layout {

    /**
     * 获取布局类型（如"flow"、"grid"、"flex"）
     */
    String getLayoutType();

    /**
     * 添加子元素到布局中
     *
     * @param element 子元素
     * @param params  该元素在布局中的参数（如网格中的行/列位置、弹性布局中的权重等）
     */
    void addChild(Dom element, LayoutParams params);

    /**
     * 移除布局中的子元素
     */
    boolean removeChild(Dom element);

    /**
     * 获取布局中的所有子元素（含布局参数）
     */
    List<LayoutChild> getChildren();

    /**
     * 获取布局自身的参数
     */
    LayoutParams getLayoutParams();

    /**
     * 设置布局自身的参数（如网格列数、弹性方向等）
     */
    void setLayoutParams(LayoutParams params);

    /**
     * 执行布局计算：根据布局规则调整子元素的位置和大小
     *
     * @param containerWidth  容器宽度
     * @param containerHeight 容器高度
     */
    void layout(int containerWidth, int containerHeight);

    /**
     * 生成布局对应的HTML结构（含子元素的布局样式）
     */
    String toHtml();

    class LayoutChild {

        private final Dom element;

        private final LayoutParams params;

        public LayoutChild(Dom element, LayoutParams params) {
            this.element = element;
            this.params = params;
        }

        public Dom getElement() {
            return element;
        }

        public LayoutParams getParams() {
            return params;
        }
    }
}

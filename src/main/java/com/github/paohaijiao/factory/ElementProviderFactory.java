package com.github.paohaijiao.factory;

import com.github.paohaijiao.common.DefaultHtmlElement;
import com.github.paohaijiao.common.Dom;
import com.github.paohaijiao.console.JConsole;
import com.github.paohaijiao.enums.HtmlElementEnums;
import com.github.paohaijiao.enums.JLogLevel;
import com.github.paohaijiao.exception.JAssert;
import com.github.paohaijiao.provider.ElementNodeProvider;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * HTML元素加载器，支持生命周期管理、SPI加载和类型注册
 */
public class ElementProviderFactory {

    protected static final ElementProviderFactory INSTANCE = new ElementProviderFactory();
    /**
     *  元素注册表：code -> 元素实例
     */
    protected final Map<String, HtmlElementLifecycle> elementRegistry = new ConcurrentHashMap<>();
    /**
     * 别名注册表：别名 -> code
     */
    protected final Map<String, String> aliasRegistry = new ConcurrentHashMap<>();
    /**
     * 元素提供者列表
     */
    protected final List<ElementNodeProvider> providers = new CopyOnWriteArrayList<>();
    /**
     * 控制台
     */
    protected JConsole console = new JConsole();
    /**
     * 初始化状态标识
     */
    protected boolean initialized = false;

    private ElementProviderFactory() {
    }

    public static ElementProviderFactory getInstance() {
        return INSTANCE;
    }

    /**
     * 构建元素构建器
     */
    public static HtmlElementBuilder buildElement(String code) {
        return new HtmlElementBuilder(code);
    }

    /**
     * 构建元素构建器
     * @param type 元素类型
     * @return
     */
    public static HtmlElementBuilder buildElement(HtmlElementEnums type) {
        return new HtmlElementBuilder(type.getCode());
    }

    /**
     * 初始化加载器，加载所有预定义元素和插件
     */
    public synchronized void initialize() {
        if (initialized) {
            return;
        }
        loadPredefinedElements();
        loadPluginElements();
        validateAllElements();
        initialized = true;
    }

    /**
     * 加载预定义元素
     */
    private void loadPredefinedElements() {
        console.log(JLogLevel.INFO, "Loaded predefined HTML elements");
    }

    /**
     * 通过SPI加载插件元素
     */
    private void loadPluginElements() {
        ServiceLoader<HtmlElementLifecycle> elements = ServiceLoader.load(HtmlElementLifecycle.class);
        for (HtmlElementLifecycle element : elements) {
            try {
                registerElement(element);
                console.log(JLogLevel.INFO, "Loaded HTML element from SPI: " + element.getClass().getName());
            } catch (Exception e) {
                console.log(JLogLevel.ERROR, "Failed to load HTML element: " + element.getClass().getName());
                e.printStackTrace();
            }
        }
    }

    /**
     * 验证所有注册的元素
     */
    private void validateAllElements() {
        for (HtmlElementLifecycle element : elementRegistry.values()) {
            validateElement(element);
        }
    }

    /**
     * 注册元素
     */
    public void registerElement(HtmlElementLifecycle element) {
        Objects.requireNonNull(element, "HtmlElement cannot be null");
        String code = element.getNodeType();
        Objects.requireNonNull(code, "HtmlElement code cannot be null");
        validateElement(element);
        if (elementRegistry.containsKey(code)) {
            JAssert.throwNewException("HtmlElement with code '" + code + "' already exists");
        }
        elementRegistry.put(code, element);
        element.init(); // 触发初始化
        String alias = element.getNodeType().toLowerCase();
        if (aliasRegistry.containsKey(alias)) {
            console.log(JLogLevel.WARN, "Alias '" + alias + "' already exists, will be overwritten");
        }
        aliasRegistry.put(alias, code);
        console.log(JLogLevel.INFO, "Registered HTML element: " + code + " - " + element.getNodeType());
    }

    /**
     * 验证元素有效性
     */
    private void validateElement(HtmlElementLifecycle element) {
        String code = element.getNodeType();
        if (code.trim().isEmpty()) {
            JAssert.throwNewException("HtmlElement code cannot be empty");
        }
        if (null!=HtmlElementEnums.codeOf(code)) {
            console.log(JLogLevel.WARN, "HtmlElement code '" + code + "' is not in HtmlElementEnums");
        }
    }

    /**
     * 根据code获取元素（返回Node接口）
     */
    public Dom getElementByCode(String code) {
        if (!initialized) {
            initialize();
        }
        HtmlElementLifecycle element = elementRegistry.get(code);
        if (element != null) {
            return element;
        }
        String actualCode = aliasRegistry.get(code.toLowerCase());
        if (actualCode != null) {
            return elementRegistry.get(actualCode);
        }
        JAssert.throwNewException("不支持的HTML元素类型: " + code);
        return null;
    }

    /**
     * 根据枚举获取元素（返回Node接口）
     */
    public Dom getElementByEnum(HtmlElementEnums elementEnum) {
        return getElementByCode(elementEnum.getCode());
    }
    /**
     * 触发渲染前事件
     */
    public void triggerBeforeRender(Dom node) {
        if (node instanceof HtmlElementLifecycle) {
            ((HtmlElementLifecycle) node).beforeRender();
        }
    }

    /**
     * 触发渲染后事件
     */
    public void triggerAfterRender(Dom node) {
        if (node instanceof HtmlElementLifecycle) {
            ((HtmlElementLifecycle) node).afterRender();
        }
    }

    /**
     * 销毁元素
     */
    public void destroyElement(Dom node) {
        if (node instanceof HtmlElementLifecycle) {
            HtmlElementLifecycle element = (HtmlElementLifecycle) node;
            String code = element.getNodeType();
            if (elementRegistry.remove(code) != null) {
                element.destroy();
                aliasRegistry.values().removeIf(v -> v.equals(code));
                console.log(JLogLevel.INFO, "Destroyed HTML element: " + code);
            }
        }
    }

    /**
     * 获取所有元素
     */
    public List<Dom> getAllElements() {
        if (!initialized) {
            initialize();
        }
        return new ArrayList<>(elementRegistry.values());
    }

    /**
     * 检查是否包含指定元素
     */
    public boolean containsElement(String code) {
        if (!initialized) {
            initialize();
        }
        return elementRegistry.containsKey(code) || aliasRegistry.containsKey(code.toLowerCase());
    }

    /**
     * 重新加载所有元素
     */
    public synchronized void reload() {
        elementRegistry.values().forEach(HtmlElementLifecycle::destroy);
        elementRegistry.clear();
        aliasRegistry.clear();
        providers.clear();
        initialized = false;
        initialize();
    }

    /**
     * HTML元素构建器
     */
    public static class HtmlElementBuilder {

        private final String code;

        private final List<String> aliases = new ArrayList<>();

        public HtmlElementBuilder(String code) {
            this.code = code;
        }
        public HtmlElementBuilder withAliases(String... aliases) {
            this.aliases.addAll(Arrays.asList(aliases));
            return this;
        }

        public HtmlElementLifecycle build() {
            return new DefaultHtmlElement(code, aliases);
        }
    }
}

package com.github.paohaijiao.style;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Style extends HashMap<String, String> {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+\\.?\\d*");

    private String cssContent;

    public Style() {
        super();
    }

    public Style(Map<String, String> initialStyles) {
        super();
        this.putAll(initialStyles);
    }

    @Override
    public String put(String property, String value) {
        if (property == null || property.trim().isEmpty()) {
            throw new IllegalArgumentException("样式属性名不能为空");
        }
        String trimmedKey = property.trim();
        String actualValue = (value == null) ? "" : value;
        return super.put(trimmedKey, actualValue);
    }

    @Override
    public void putAll(Map<? extends String, ? extends String> m) {
        m.forEach((k, v) -> {
            if (k != null && !k.trim().isEmpty()) {
                put(k, v);
            }
        });
    }

    @Override
    public String get(Object property) {
        return property instanceof String ? super.get(((String) property).trim()) : null;
    }

    @Override
    public boolean containsKey(Object property) {
        return property instanceof String && super.containsKey(((String) property).trim());
    }

    /**
     * 设置CSS内容（用于style标签）
     */
    public void setContent(String cssContent) {
        this.cssContent = cssContent;
    }

    /**
     * 获取CSS内容
     */
    public String getContent() {
        return cssContent;
    }

    /**
     * 获取文本颜色
     */
    public String getColor() {
        return get("color");
    }

    /**
     * 设置文本颜色（支持颜色名、十六进制、rgb/rgba）
     * 等价于 put("color", colorValue)
     */
    public void setColor(String colorValue) {
        put("color", colorValue);
    }

    /**
     * 获取背景颜色
     */
    public String getBackgroundColor() {
        return get("background-color");
    }

    /**
     * 设置背景颜色
     */
    public void setBackgroundColor(String colorValue) {
        put("background-color", colorValue);
    }

    /**
     * 获取字体大小
     */
    public String getFontSize() {
        return get("font-size");
    }

    /**
     * 设置字体大小（建议带单位，如 "16px"、"1.2rem"）
     */
    public void setFontSize(String size) {
        put("font-size", size);
    }

    /**
     * 获取字体家族
     */
    public String getFontFamily() {
        return get("font-family");
    }

    /**
     * 设置字体家族（如 "Arial, sans-serif"）
     */
    public void setFontFamily(String fontFamily) {
        put("font-family", fontFamily);
    }

    /**
     * 获取宽度
     */
    public String getWidth() {
        return get("width");
    }

    /**
     * 设置宽度（支持 "100px"、"50%"、"auto"）
     */
    public void setWidth(String width) {
        put("width", width);
    }

    /**
     * 获取高度
     */
    public String getHeight() {
        return get("height");
    }

    /**
     * 设置高度
     */
    public void setHeight(String height) {
        put("height", height);
    }

    /**
     * 获取边框样式
     */
    public String getBorder() {
        return get("border");
    }

    /**
     * 设置边框（如 "1px solid #000"）
     */
    public void setBorder(String border) {
        put("border", border);
    }

    /**
     * 设置内边距（padding，支持单值、双值、四值）
     * 如 "10px"、"10px 20px"、"5px 10px 15px 20px"
     */
    public void setPadding(String padding) {
        put("padding", padding);
    }

    /**
     * 设置外边距（margin）
     */
    public void setMargin(String margin) {
        put("margin", margin);
    }

    /**
     * 设置定位方式（position，如 "static"、"relative"、"absolute"、"fixed"）
     */
    public void setPosition(String position) {
        put("position", position);
    }

    /**
     * 设置左偏移（left，配合定位使用）
     */
    public void setLeft(String left) {
        put("left", left);
    }

    /**
     * 设置上偏移（top，配合定位使用）
     */
    public void setTop(String top) {
        put("top", top);
    }

    /**
     * 设置文本对齐方式（text-align，如 "left"、"center"、"right"）
     */
    public void setTextAlign(String align) {
        put("text-align", align);
    }

    /**
     * 清除指定样式属性（等价于 remove，但参数更明确）
     */
    public void clearStyle(String property) {
        remove(property);
    }

    /**
     * 清除所有样式
     */
    public void clearAllStyles() {
        clear();
        cssContent = null;
    }

    /**
     * 转换为 HTML 元素的 style 属性字符串（如 "color:red;font-size:16px"）
     */
    public String toStyleString() {
        StringBuilder sb = new StringBuilder();
        Set<Entry<String, String>> entries = entrySet();
        for (Entry<String, String> entry : entries) {
            if (sb.length() > 0) {
                sb.append(";");
            }
            sb.append(entry.getKey()).append(":").append(entry.getValue());
        }
        return sb.toString();
    }

    /**
     * 转换为 CSS 代码块格式（如 "{\n  color: red;\n  font-size: 16px;\n}"）
     */
    public String toCssBlock() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder("{\n");
        Set<Entry<String, String>> entries = entrySet();
        for (Entry<String, String> entry : entries) {
            sb.append("  ")
                    .append(entry.getKey())
                    .append(": ")
                    .append(entry.getValue())
                    .append(";\n");
        }
        sb.append("}");
        return sb.toString();
    }

    /**
     * 获取原始样式值（String类型，等价于get方法）
     */
    public String getString(String property) {
        return get(property);
    }

    /**
     * 获取整数类型的样式值（自动提取数值，忽略单位）
     * 例如："12px" → 12，" -30" → -30，非数值返回默认值
     */
    public int getInt(String property, int defaultValue) {
        String value = get(property);
        if (value == null || value.trim().isEmpty()) {
            return defaultValue;
        }
        try {
            Matcher matcher = NUMBER_PATTERN.matcher(value.trim());
            if (matcher.find()) {
                return (int) Double.parseDouble(matcher.group());
            }
            return defaultValue;
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    /**
     * 获取整数类型的样式值（默认值为0）
     */
    public int getInt(String property) {
        return getInt(property, 0);
    }

    /**
     * 获取浮点类型的样式值（自动提取数值，忽略单位）
     * 例如："12.5em" → 12.5，" -3.14" → -3.14，非数值返回默认值
     */
    public float getFloat(String property, float defaultValue) {
        String value = get(property);
        if (value == null || value.trim().isEmpty()) {
            return defaultValue;
        }
        try {
            Matcher matcher = NUMBER_PATTERN.matcher(value.trim());
            if (matcher.find()) {
                return Float.parseFloat(matcher.group());
            }
            return defaultValue;
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    /**
     * 获取浮点类型的样式值（默认值为0.0f）
     */
    public float getFloat(String property) {
        return getFloat(property, 0.0f);
    }

    /**
     * 获取布尔类型的样式值（支持"true"/"false"、"yes"/"no"、"1"/"0"）
     * 例如："true" → true，"no" → false，其他值返回默认值
     */
    public boolean getBoolean(String property, boolean defaultValue) {
        String value = get(property);
        if (value == null || value.trim().isEmpty()) {
            return defaultValue;
        }
        String trimmed = value.trim().toLowerCase();
        if ("true".equals(trimmed) || "yes".equals(trimmed) || "1".equals(trimmed)) {
            return true;
        } else if ("false".equals(trimmed) || "no".equals(trimmed) || "0".equals(trimmed)) {
            return false;
        } else {
            return defaultValue;
        }
    }

    /**
     * 获取布尔类型的样式值（默认值为false）
     */
    public boolean getBoolean(String property) {
        return getBoolean(property, false);
    }

    /**
     * 获取样式值的单位（如"12px" → "px"，"50%" → "%"，无单位返回空字符串）
     */
    public String getUnit(String property) {
        String value = get(property);
        if (value == null || value.trim().isEmpty()) {
            return "";
        }
        Matcher matcher = NUMBER_PATTERN.matcher(value.trim());// 提取非数值部分作为单位
        if (matcher.find()) {
            return value.trim().replace(matcher.group(), "").trim();
        }
        return value.trim();
    }

    /**
     * 获取当前样式容器的Map对象（返回副本，避免外部修改内部状态）
     */
    public Map<String, String> getMap() {
        return new HashMap<>(this);
    }

    @Override
    public String toString() {
        if (cssContent != null && !cssContent.trim().isEmpty()) {
            return cssContent;
        }
        return toStyleString();
    }

    /**
     * 判断是否有CSS内容
     */
    public boolean hasContent() {
        return cssContent != null && !cssContent.trim().isEmpty();
    }

    /**
     * 判断是否有内联样式
     */
    public boolean hasInlineStyles() {
        return !isEmpty();
    }
    protected String getStyleString() {
        if (hasContent()) {
            return getContent().trim();
        }
        if (hasInlineStyles()) {
            return toStyleString();
        }
        return "";
    }
}
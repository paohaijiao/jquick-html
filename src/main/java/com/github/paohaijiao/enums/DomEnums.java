package com.github.paohaijiao.enums;

import lombok.Getter;

@Getter
public enum DomEnums {

    html("html", "html"),

    document("document", "document"),

    meta("meta", "meta"),

    link("link", "link"),

    head("head", "head"),

    body("body", "body"),

    header("header", "header"),

    div("div", "div"),

    aside("aside", "aside"),

    main("main", "main"),

    h1("h1", "h1"),

    h2("h2", "h2"),

    h3("h3", "h3"),

    h4("h4", "h4"),

    h5("h5", "h5"),

    h6("h6", "h6"),

    ul("ul", "ul"),

    ol("ol", "ol"),

    li("li", "li"),

    table("table", "table"),

    thead("thead", "thead"),

    tr("tr", "tr"),

    th("th", "th"),

    td("td", "td"),

    heading("heading", "heading"),

    span("span", "span"),

    i("i", "i"),

    button("button", "button"),

    a("a", "a"),

    p("p", "p"),

    label("label", "label"),

    select("select", "select"),

    option("option", "option"),

    img("img", "img"),

    svg("svg", "svg"),


    ;

    private final String code;
    private final String name;

    DomEnums(String code, String name) {
        this.code = code;
        this.name = name;
    }
    public static DomEnums codeOf(String code) {
     for (DomEnums e : values()) {
         if (e.code.equals(code)) {
             return e;
         }
     }
     return null;
    }
}

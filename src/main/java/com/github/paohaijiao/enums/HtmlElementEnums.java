package com.github.paohaijiao.enums;

import lombok.Getter;

@Getter
public enum HtmlElementEnums
{
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
    li("li", "li"),
    table("table", "table"),
    thead("thead", "thead"),
    tr("tr", "tr"),
    th("th", "th"),
    heading("heading", "heading"),
    span("span", "span"),
    i("i", "i"),
    button("button", "button"),
    a("a", "a"),
    label("label", "label"),
    select("select", "select"),
    option("option", "option"),
    img("img", "img"),
    svg("svg", "svg"),


    ;

    private String code;
    private String name;

     HtmlElementEnums(String code, String name){
        this.code = code;
        this.name = name;
    }
}

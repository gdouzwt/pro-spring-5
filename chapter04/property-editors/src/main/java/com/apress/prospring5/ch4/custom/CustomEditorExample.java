package com.apress.prospring5.ch4.custom;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * 演示自定义使用 Property Editor
 */
public class CustomEditorExample {
    private FullName name;

    public FullName getName() {
        return name;
    }

    // Setter 注入 FullName Bean
    // 自定义的 NamePropertyEditor 会将从 xml 配置文件读取到的 String 形式
    // 转成 FullName 对象的属性。
    // 所谓 PropertyEditor 应该是 Bean 的属性编辑器吧
    // 这里 name 是 CustomEditorExample 这粒 Bean 的属性
    // 然后通过自定义，并注册一个 NamePropertyEditor，使得 Spring 知道怎样处理
    // 在 xml 读取到的字符串形式的属性值。
    public void setName(FullName name) {
        this.name = name;
    }

    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-02.xml");
        ctx.refresh();

        CustomEditorExample bean =
            (CustomEditorExample) ctx.getBean("exampleBean");

        System.out.println(bean.getName());

        ctx.close();
    }
}

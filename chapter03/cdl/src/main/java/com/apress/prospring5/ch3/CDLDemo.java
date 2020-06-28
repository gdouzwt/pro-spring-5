package com.apress.prospring5.ch3;

public class CDLDemo {
    public static void main(String... args) {
        // 得先创建个容器
        Container container = new DefaultContainer();

        // 然后查找依赖
        ManagedComponent managedComponent = new ContextualizedDependencyLookup();
        managedComponent.performLookup(container);

        // 调用的是实现类的 toString 方法。
        System.out.println(managedComponent);
    }
}

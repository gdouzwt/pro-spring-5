package com.apress.prospring5.ch3;

/**
 * 被管理的组件，通过向容器查找依赖
 */
public interface ManagedComponent {
    void performLookup(Container container);
}

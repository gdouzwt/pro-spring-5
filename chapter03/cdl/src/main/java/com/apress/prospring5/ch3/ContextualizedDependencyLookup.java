package com.apress.prospring5.ch3;

/**
 * 被管理的组件的一个实现
 */
public class ContextualizedDependencyLookup implements ManagedComponent {
    // 想要的依赖项
    private Dependency dependency;

    // 从容器中找到依赖
    @Override
    public void performLookup(Container container) {
        this.dependency = (Dependency) container.getDependency("myDependency");
    }

    @Override
    public String toString() {
        return dependency.toString();
    }
}

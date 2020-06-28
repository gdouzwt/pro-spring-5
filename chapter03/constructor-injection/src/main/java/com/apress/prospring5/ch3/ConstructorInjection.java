package com.apress.prospring5.ch3;

// 普通的构造器注入例子
public class ConstructorInjection {

    private Dependency dependency;

    public ConstructorInjection(Dependency dependency) {
        this.dependency = dependency;
    }

    @Override
    public String toString() {
        return dependency.toString();
    }
}

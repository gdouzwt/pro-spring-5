package com.apress.prospring5.ch3;

/**
 * 容器接口的一个默认实现，写死了依赖查找的逻辑
 */
public class DefaultContainer implements Container {
    /**
     *
     * @param key 查找依赖所使用的 key，根据这个 key 去找到需要的依赖
     * @return 如果提供的 key 的值等于 "myDependency" 则返回新的依赖项实例，
     * 否则抛出异常
     */
    @Override
    public Object getDependency(String key) {
        if ("myDependency".equals(key)) {
            return new Dependency();
        }

        throw new RuntimeException("Unknown dependency: " + key);
    }
}

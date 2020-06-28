package com.apress.prospring5.ch3;

/**
 * 管理依赖的容器
 */
public interface Container {
    /**
     *
     * @param key 查找依赖所使用的 key，根据这个 key 去找到需要的依赖
     * @return 返回依赖项对象实例
     */
    Object getDependency(String key);
}

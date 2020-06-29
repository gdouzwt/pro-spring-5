package com.apress.prospring5.ch3;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * 通过实现 MethodReplacer 接口，提供替换方法的实现
 * 下面可以看看 MethodReplacer 的源码
 * public interface MethodReplacer {
 * Object reimplement(Object obj, Method method, Object[] args) throws Throwable;
 * }
 */
public class FormatMessageReplacer implements MethodReplacer {

    /**
     *
     * @param target 要被进行方法替换的 Bean
     * @param method 被替换的方法
     * @param args 被替换方法的形参
     */
    @Override
    public Object reimplement(Object target, Method method, Object[] args) {
        if (isFormatMessageMethod(method)) {
            String msg = (String) args[0];
            return "<h2>" + msg + "</h2>";
        } else {
            throw new IllegalArgumentException("Unable to reimplement method "
                + method.getName());
        }
    }

    // 判断要替换的方法是否是 formatMessage 方法
    private boolean isFormatMessageMethod(Method method) {
        // 如果参数列表长度不为 1 则说明方法签名不匹配
        if (method.getParameterTypes().length != 1) {
            return false;
        }
        // 看看方法名是否匹配
        if (!("formatMessage".equals(method.getName()))) {
            return false;
        }
        // 判断返回值类型
        if (method.getReturnType() != String.class) {
            return false;
        }
        // 最后如果形参类型为 String 则说明全部条件都匹配，可以进行方法替换
        return method.getParameterTypes()[0] == String.class;
    }
}

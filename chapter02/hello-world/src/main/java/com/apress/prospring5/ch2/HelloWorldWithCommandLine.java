package com.apress.prospring5.ch2;


/**
 * 简单起步的时候演示的例子，从命令行输入参数，算是一种配置方式
 */
public class HelloWorldWithCommandLine {

    public static void main(String... args) {
        if (args.length > 0) {
            System.out.println(args[0]);
        } else {
            System.out.println("Hello World!");
        }
    }
}

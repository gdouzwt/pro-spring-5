package com.apress.prospring5.ch5;

import com.apress.prospring5.ch5.compiletimeweaving.DemoAspect;
import com.apress.prospring5.ch5.demo.DemoClass;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring/app-context-xml.xml")
class AspectJDemoTest {

    @Test
    public void adviceIsCalled() {
        assertFalse(DemoAspect.isCalled());
        DemoClass demoClass = new DemoClass();
        demoClass.callsTheAdvisedMethod();
        assertTrue(DemoAspect.isCalled());
    }

    /*标准输出的测试有点不好观察*/
    @Disabled
    @Test
    public void testWithSpring() {
        MessageWriter writer = new MessageWriter();
        writer.writeMessage();
        writer.foo();
    }

}

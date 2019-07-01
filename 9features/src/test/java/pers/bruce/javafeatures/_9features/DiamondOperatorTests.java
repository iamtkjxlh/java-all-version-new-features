package pers.bruce.javafeatures._9features;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/**
 * 钻石操作符
 * @author Bruce.Tong
 * @date 2019/7/1
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DiamondOperatorTests {

    /**
     * @description 一个简单的抽象类
     * @author Bruce.Tong
     * @date 2019/7/1
     */
    abstract class Handler<T>{
        T content;
        Handler(T t){
            this.content = t;
        }
        abstract void op();
    }

    /**
     * @description 测试读取字符串
     * @author Bruce.Tong
     * @date 2019/7/1
     */
    @Test
    public void testHandler() {
        Handler<Integer> intHandler = new Handler<>(1) {
            @Override
            public void op() {
                System.out.println(content);
            }
        };
        intHandler.op();
        Handler<? extends Number> intHandler1 = new Handler<>(2) {
            @Override
            public void op() {
                System.out.println(content);
            }
        };
        intHandler1.op();
        Handler<?> handler = new Handler<>("test") {
            @Override
            public void op() {
                System.out.println(content);
            }
        };
        handler.op();
    }
}

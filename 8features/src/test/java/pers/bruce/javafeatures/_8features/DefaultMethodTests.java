package pers.bruce.javafeatures._8features;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.function.IntFunction;

/**
 * @description 默认方法相关单元测试
 * @author Bruce.Tong
 * @date 2019/6/19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DefaultMethodTests {
    interface FruitInterface {
        default void printMe(){
            System.out.println("我是一个水果");
        }
        static void sayHi(){
            System.out.println("嗨，你们好吗");
        }
    }
    interface YellowInterface {
        default void printMe(){
            System.out.println("我是黄色的");
        }
    }
    /**
     * @description 实现了接口的方法
     * @author Bruce.Tong
     * @date 2019/6/19
     */
    class MyClass implements FruitInterface,YellowInterface{
        public void printMe(){
            FruitInterface.super.printMe();
            YellowInterface.super.printMe();
            FruitInterface.sayHi();
            System.out.println("我是个香蕉");
        }
    }
    /**
     * @description 测试默认方法
     * @author Bruce.Tong
     * @date 2019/6/19
     */
    @Test
    public void testPrintMe() {
        new MyClass().printMe();
    }
}

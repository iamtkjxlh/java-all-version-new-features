package pers.bruce.javafeatures._8features;

import org.apache.tomcat.util.buf.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.IntFunction;

/**
 * @description 方法引用相关单元测试
 * @author Bruce.Tong
 * @date 2019/6/19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MethodReferenceTests {
    /**
     * @description 静态方法输出内容
     * @author Bruce.Tong
     * @date 2019/6/19
     */
    private static void print(String input){
        System.out.print(input);
    }
    /**
     * @description 静态方法输出类名
     * @author Bruce.Tong
     * @date 2019/6/19
     */
    private static <T> void printClassName(Class<T> input){
        System.out.print(input.getName());
    }
    /**
     * @description 带构造方法的类
     * @author Bruce.Tong
     * @date 2019/6/19
     */
    class MyClass{
        public MyClass(int n){
            System.out.println(n);
        }
    }
    interface MyFunc {
        MyClass func(int n);
    }
    /**
     * @description 静态方法
     * @author Bruce.Tong
     * @date 2019/6/19
     */
    @Test
    public void testStatic() {
        String[] array = new String[]{"c","d","a","b"};
        List<String> tempList = CollectionUtils.arrayToList(array);
        tempList.forEach(MethodReferenceTests::print);
    }
    /**
     * @description 实例方法
     * @author Bruce.Tong
     * @date 2019/6/19
     */
    @Test
    public void testInstance() {
        String[] array = new String[]{"c","d","a","b"};
        List<String> tempList = CollectionUtils.arrayToList(array);
        tempList.forEach(System.out::print);
    }
    /**
     * @description 带类型的方法
     * @author Bruce.Tong
     * @date 2019/6/19
     */
    @Test
    public void testType() {
        Class[] array = new Class[]{String.class};
        List<Class> tempList = CollectionUtils.arrayToList(array);
        tempList.forEach(MethodReferenceTests::<String>printClassName);
    }
    /**
     * @description 构造方法
     * @author Bruce.Tong
     * @date 2019/6/19
     */
    @Test
    public void testNewIncetance() {
        //普通类
        MyFunc myFunc = MyClass::new;
        myFunc.func(10);
        //数组类型
        IntFunction<int[]> arrayMaker = int[]::new;
        int[] intArray = arrayMaker.apply(10);
    }
}

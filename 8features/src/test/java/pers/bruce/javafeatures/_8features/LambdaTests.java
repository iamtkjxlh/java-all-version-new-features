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

/**
 * @description 测试lambda表达式的各种写法
 * @author Bruce.Tong
 * @date 2019/6/19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LambdaTests {
    /**
     * @description 有继承FunctionalInterface的无参数接口
     * @author Bruce.Tong
     * @date 2019/6/19
     */
    @FunctionalInterface
    interface NoParamInterfaceExtend{
        int outputTestInt();
    }

    /**
     * @description 无继承FunctionalInterface的无参数接口
     * @author Bruce.Tong
     * @date 2019/6/19
     */
    interface interfaceNoExtend{
        int outputTestInt();
    }

    /**
     * @description 输出随机数
     * @author Bruce.Tong
     * @date 2019/6/19
     */
    private int outputRadom(NoParamInterfaceExtend fi){
        return fi.outputTestInt();
    }

    /**
     * @description 有参数，单行
     * @author Bruce.Tong
     * @date 2019/6/19
     */
    @Test
    public void testLambdaWithParamSingle() {
        String[] array = new String[]{"c","d","a","b"};
        System.out.println("原始内容："+StringUtils.join(array));
        List<String> tempList;
        //普通写法
        tempList = CollectionUtils.arrayToList(array);
        Collections.sort(tempList, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
        System.out.println("普通写法："+StringUtils.join(tempList));
        //lambda写法
        tempList = CollectionUtils.arrayToList(array);
        Collections.sort(tempList, (s1, s2) -> s1.compareTo(s2));
        System.out.println("lambda写法："+StringUtils.join(tempList));
    }

    /**
     * @description 无参数，单行
     * @author Bruce.Tong
     * @date 2019/6/19
     */
    @Test
    public void testLambdaWithoutParamSingle() {
        System.out.println("输出一个随机数："+outputRadom(()->new Random().nextInt()));
    }

    /**
     * @description 无参数，多行
     * @author Bruce.Tong
     * @date 2019/6/19
     */
    @Test
    public void testLambdaWithoutParamMulti() {
        System.out.println("输出一个100以内的随机数："+outputRadom(()->{
            int a = new Random().nextInt();
            a = Math.abs(a%100);
            return a;
        }));
    }

    /**
     * @description 有参数，多行
     * @author Bruce.Tong
     * @date 2019/6/19
     */
    @Test
    public void testLambdaWithParamMulti() {
        String[] array = new String[]{"c","d","a","b"};
        System.out.println("原始内容："+StringUtils.join(array));
        List<String> tempList = CollectionUtils.arrayToList(array);
        Collections.sort(tempList, (s1, s2) -> {
            if(s1.equals(s2)){
                return 0;
            }else if(s1.compareTo(s2)>0){
                return 1;
            }else{
                return -1;
            }
        });
        System.out.println("排序结果："+StringUtils.join(tempList));
    }
}

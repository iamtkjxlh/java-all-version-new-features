package pers.bruce.javafeatures._8features;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

/**
 * @description Optional相关单元测试
 * @author Bruce.Tong
 * @date 2019/6/19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OptionalTests {

    /**
     * @description optional作为参数
     * @author Bruce.Tong
     * @date 2019/6/24
     */
    private void paramOptional(Optional<Integer> optional){
        System.out.println("接收到参数："+optional.get());
    }

    /**
     * @description 测试optional
     * @author Bruce.Tong
     * @date 2019/6/24
     */
    @Test
    public void testOptional() {
        Optional<Integer> number = Optional.ofNullable(10);
        Optional<Integer> none = Optional.ofNullable(null);
        //普通的情况
        System.out.println("数字："+number.get());
        //为空的情况
        try{
            none.get();
        }catch (Exception e){
            System.out.println("为空异常："+e.getMessage());
        }
        //作为参数
        paramOptional(number);
        //判断是否为空
        System.out.println("不为空："+number.isPresent()+" 为空："+none.isPresent());
        //返回默认值
        System.out.println("默认值："+none.orElse(20));
        //会抛异常
        try{
            Optional<Integer> ex = Optional.of(null);
        }catch (Exception e){
            System.out.println("设置空值异常："+e.getMessage());
        }


    }
}

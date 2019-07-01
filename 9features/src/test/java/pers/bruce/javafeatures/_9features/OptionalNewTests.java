package pers.bruce.javafeatures._9features;

import org.apache.tomcat.util.buf.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 改进的Optional
 * @author Bruce.Tong
 * @date 2019/7/1
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OptionalNewTests {
    /**
     * @description 用flatmap测试optional.stream
     * @author Bruce.Tong
     * @date 2019/7/1
     */
    @Test
    public void testHandler() {
        List<Optional<String>> list = List.of(Optional.of("a"),Optional.empty(),Optional.of("b"),Optional.empty());
        List<String> newList = list.stream().flatMap(Optional::stream).collect(Collectors.toList());
        System.out.println(StringUtils.join(newList));
    }

    /**
     * @description 测试ifPresentOrElse
     * @author Bruce.Tong
     * @date 2019/7/1
     */
    @Test
    public void testIfPresentOrElse(){
        //测试有值的情况
        Optional<Integer> optional = Optional.of(1);
        optional.ifPresentOrElse( x -> System.out.println("Value: " + x),() ->
                System.out.println("Not Present."));
        //测试没有值的情况
        optional = Optional.empty();
        optional.ifPresentOrElse( x -> System.out.println("Value: " + x),() ->
                System.out.println("Not Present."));
    }

    /**
     * @description 测试or
     * @author Bruce.Tong
     * @date 2019/7/1
     */
    @Test
    public void testOr(){
        //测试有值的情况
        Optional<Integer> optional = Optional.of(1);
        System.out.println("Value:"+optional.or(()->Optional.of(0)).get());
        //测试没有值的情况
        optional = Optional.empty();
        System.out.println("Value:"+optional.or(()->Optional.of(0)).get());
    }
}

package pers.bruce.javafeatures._9features;

import org.apache.tomcat.util.buf.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 新的streamApi
 * @author Bruce.Tong
 * @date 2019/6/27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StreamNewApiTests {

    /**
     * @description 测试takewile，一旦返回false立即停止循环
     * @author Bruce.Tong
     * @date 2019/6/27
     */
    @Test
    public void testTakewile() {
        List<String> list = List.of("a","b","c","d","e");
        list = list.stream().takeWhile(r->!r.equals("c")).collect(Collectors.toList());
        System.out.println(StringUtils.join(list));
    }

    /**
     * @description 测试dropwhile，一旦返回true则仅返回后面的元素
     * @author Bruce.Tong
     * @date 2019/6/27
     */
    @Test
    public void testDropwile() {
        List<String> list = List.of("a","b","c","d","e");
        list = list.stream().dropWhile(r->!r.equals("c")).collect(Collectors.toList());
        System.out.println(StringUtils.join(list));
    }

    /**
     * @description 测试ofNullable，只能输入非空内容作为流
     * @author Bruce.Tong
     * @date 2019/6/27
     */
    @Test
    public void testOfNullable() {
        List<String> list = Stream.ofNullable("a").collect(Collectors.toList());
        System.out.println(list.size()+" "+StringUtils.join(list));

        List list2 = Stream.ofNullable(null).collect(Collectors.toList());
        System.out.println(list2.size()+" "+StringUtils.join(list2));
    }

    /**
     * @description 测试Iterate，自创种子创建流
     * @author Bruce.Tong
     * @date 2019/6/27
     */
    @Test
    public void testIterate() {
        List<String> list = new ArrayList<>();
        IntStream.iterate(1, i->i<10, i->i+1).forEach(i->list.add(i+""));
        System.out.println(StringUtils.join(list));
    }
}

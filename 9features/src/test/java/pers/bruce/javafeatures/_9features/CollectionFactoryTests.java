package pers.bruce.javafeatures._9features;

import net.minidev.json.JSONObject;
import org.apache.tomcat.util.buf.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 集合工厂类
 * @author Bruce.Tong
 * @date 2019/6/26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CollectionFactoryTests {

    /**
     * list的集合工厂类
     * @author Bruce.Tong
     * @date 2019/6/26
     */
    @Test
    public void testList() {
        List<String> list = List.of("a","b","c");
        System.out.println("用集合工厂类创建list："+StringUtils.join(list));
    }

    /**
     * set的集合工厂类
     * @author Bruce.Tong
     * @date 2019/6/26
     */
    @Test
    public void testSet(){
        Set<String> set = Set.of("a","b","c");
        System.out.println("用集合工厂类创建set："+StringUtils.join(set));
    }

    /**
     * map的集合工厂类
     * @author Bruce.Tong
     * @date 2019/6/26
     */
    @Test
    public void testMap(){
        Map<String,Integer> map = Map.of("a",1,"b",2,"c",3);
        System.out.println("用集合工厂类创建map："+JSONObject.toJSONString(map));
        map = Map.ofEntries(new AbstractMap.SimpleEntry<>("a",1),
                new AbstractMap.SimpleEntry<>("b",2),
                new AbstractMap.SimpleEntry<>("c",3));
        System.out.println("用集合工厂类（entry）创建map："+JSONObject.toJSONString(map));
    }
}

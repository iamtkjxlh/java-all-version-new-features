package pers.bruce.javafeatures._8features;

import net.minidev.json.JSONObject;
import org.apache.tomcat.util.buf.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @description StreamApi相关单元测试
 * @author Bruce.Tong
 * @date 2019/6/19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StreamApiTests {
    /**
     * @description 测试执行List相关
     * @author Bruce.Tong
     * @date 2019/6/19
     */
    @Test
    public void testList() {
        List<String> strings = CollectionUtils.arrayToList(new String[]{"hi","hey","hello","good","nice",""});
        System.out.println("原始字符串："+StringUtils.join(strings));
        List<String> result;
        //输出空字符串数量
        result = strings.stream()
                .filter(String::isEmpty)
                .collect(Collectors.toList());
        System.out.println("空字符串数量："+result.size());
        //长度大于3的字符串
        result = strings.stream()
                .filter(s->s.length()>3)
                .collect(Collectors.toList());
        System.out.println("长度大于3的字符串："+StringUtils.join(result));
        //转字符串
        String joinStr = strings.stream()
                .collect(Collectors.joining());
        System.out.println("合并后的字符串："+joinStr);
        //改变原先的元素
        result = strings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("转大写后的字符串："+StringUtils.join(result));
        //转map
        Map<String,String> map = strings.stream()
                .collect(Collectors.toMap(key->String.valueOf(key.hashCode()), value->value));
        System.out.println("转map后的字符串："+ JSONObject.toJSONString(map));
    }

    /**
     * @description 测试执行summaryStatistics相关
     * @author Bruce.Tong
     * @date 2019/6/19
     */
    @Test
    public void testSummaryStatistics() {
        Random random = new Random();
        List<Integer> ints = new ArrayList<>();
        for(int i=0; i < 10; i++){
            ints.add(random.nextInt());
        }
        System.out.println("原始数字："+ StringUtils.join(ints.stream().map(i->String.valueOf(i)).collect(Collectors.toList())));
        IntSummaryStatistics stats = ints.stream().mapToInt(i->i).summaryStatistics();
        System.out.println("列表中最大的值："+ stats.getMax());
        System.out.println("列表中最小的值："+ stats.getMin());
        System.out.println("列表中所有数值之和："+ stats.getSum());
        System.out.println("列表中的平均数："+ stats.getAverage());
        System.out.println("列表元素数量："+ stats.getCount());
    }

    /**
     * @description 测试执行并行相关
     * @author Bruce.Tong
     * @date 2019/6/19
     */
    @Test
    public void testParallel() {
        List<String> strings = CollectionUtils.arrayToList(new String[]{"hi","hey","hello","good","nice",""});
        System.out.println("原始字符串："+StringUtils.join(strings));
        //parallel stream
        long count = strings.parallelStream().filter(String::isEmpty).count();
        System.out.println("空元素数量："+ count);
        //多线程reduce
        //第一个参数用于存放合并结果；第二个参数用于多线程执行的方法；第三个参数是本地合并方法，只有当两个参数不一致时才需要合并
        List<String> result = strings.parallelStream().reduce(new ArrayList<String>(),(list,str)->{
            if(!str.isEmpty()){
                list.add(str);
            }
            return list;
        }, (acc,item)->{
            ArrayList<String> res;
            if(acc!=item){
                res = new ArrayList<>(acc);
                res.addAll(item);
            }else{
                res = acc;
            }
            return res;
        });
        System.out.println("用reduce去除了空元素："+StringUtils.join(result));
        //简单reduce
        Random random = new Random();
        List<Integer> ints = new ArrayList<>();
        for(int i=0; i < 10; i++){
            ints.add(random.nextInt());
        }
        System.out.println("原始数字："+ StringUtils.join(ints.stream().map(i->String.valueOf(i)).collect(Collectors.toList())));
        int intResult = ints.parallelStream().reduce(0,(sum,value)->{
           return sum+value;
        });
        System.out.println("reduce求和结果："+intResult);
    }
}

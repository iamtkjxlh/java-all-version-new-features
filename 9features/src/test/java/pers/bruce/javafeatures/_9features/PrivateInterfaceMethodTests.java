package pers.bruce.javafeatures._9features;

import net.minidev.json.JSONObject;
import org.apache.tomcat.util.buf.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 私有接口方法
 * @author Bruce.Tong
 * @date 2019/6/26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PrivateInterfaceMethodTests {

    interface TestInterface{
        private void log(){
            System.out.println("这是一个私有方法");
        }
        default void output(){
            log();
        }
    }

    /**
     * 执行私有化方法
     * @author Bruce.Tong
     * @date 2019/6/26
     */
    @Test
    public void testOutpout() {
        TestInterface ti = new TestInterface(){};
        ti.output();
    }
}

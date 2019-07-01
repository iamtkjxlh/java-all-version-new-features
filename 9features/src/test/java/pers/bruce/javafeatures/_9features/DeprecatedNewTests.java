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
 * 改进的Deprecated
 * @author Bruce.Tong
 * @date 2019/7/1
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DeprecatedNewTests {

    /**
     * @description 这是一个弃用的方法
     * @author Bruce.Tong
     * @date 2019/7/1
     */
    @Deprecated(since = "1.9",forRemoval=true)
    @Test
    public void testDeprecatedData() {
        System.out.println("this is a deprecated method");
    }
}

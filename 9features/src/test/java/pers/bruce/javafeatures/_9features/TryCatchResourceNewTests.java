package pers.bruce.javafeatures._9features;

import org.apache.tomcat.util.buf.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 新的try catch resource
 * @author Bruce.Tong
 * @date 2019/7/1
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TryCatchResourceNewTests {

    /**
     * @description 测试读取字符串
     * @author Bruce.Tong
     * @date 2019/7/1
     */
    @Test
    public void testReadData() {
        Reader stringReader = new StringReader("test string");
        BufferedReader bufferedReader = new BufferedReader(stringReader);
        try(bufferedReader){
            System.out.println(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

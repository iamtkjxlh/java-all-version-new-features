package pers.bruce.javafeatures._8features;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @description Nashorn相关单元测试
 * @author Bruce.Tong
 * @date 2019/6/19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JjsTests {
    /**
     * @description 测试执行jjs
     * @author Bruce.Tong
     * @date 2019/6/19
     */
    @Test
    public void testJjs() {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");
        StringBuilder str = new StringBuilder();
        //这里使用了js引用java类型的方法
        str.append("var BigDecimal = Java.type('java.math.BigDecimal');");
        str.append("var result = new BigDecimal(2).multiply(new BigDecimal(\"100\"));");
        str.append("print(result.toPlainString())");
        try {
            nashorn.eval(str.toString());
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}

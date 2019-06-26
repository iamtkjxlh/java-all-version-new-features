package pers.bruce.javafeatures._9featuresmod;

import java.util.logging.Logger;

/**
 * @author Bruce.Tong
 * @description main
 * @date 2019/6/24
 */
public class Main {

    private static final Logger logger = Logger.getLogger("Hello World");

    public static void main(String[] args){
        System.out.println("获取模块成功！"+logger.getClass().getName());
    }
}

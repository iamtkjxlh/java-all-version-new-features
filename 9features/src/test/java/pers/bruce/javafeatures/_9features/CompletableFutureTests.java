package pers.bruce.javafeatures._9features;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BaseMultiResolutionImage;
import java.awt.image.MultiResolutionImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 可完成的任务类
 * @author Bruce.Tong
 * @date 2019/7/1
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CompletableFutureTests {
    /**
     * @description 可完成的future子类，可以替换线程池
     * @author Bruce.Tong
     * @date 2019/7/1
     */
    class MyCompletableFuture<T> extends CompletableFuture<T>{
        public Executor defaultExecutor(){
            return Executors.newCachedThreadPool();
        }
    }

    /**
     * @description 测试延迟执行
     * @author Bruce.Tong
     * @date 2019/7/1
     */
    @Test
    public void testDelays() throws IOException {
        //一个2秒钟的线程，返回1
        CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        })

                //线程结果+1
                .thenApply(i->i+1)
                //和另一个线程结果合并
                .thenCombine(CompletableFuture.completedFuture(10),(a,b)->a+b)
                //如果超时则返回100
                .completeOnTimeout(100,1000,TimeUnit.MILLISECONDS)
                //输出结果
                .thenAccept(i->System.out.println("over:"+(i)))
                //延迟200毫秒执行
                .delayedExecutor(200,TimeUnit.MILLISECONDS);
        //等待线程完毕
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * @description 测试工厂方法
     * @author Bruce.Tong
     * @date 2019/7/1
     */
    @Test
    public void testFactories() throws IOException {
        CompletableFuture.completedFuture(1).thenAccept(i->System.out.println("complete future with:"+i));
        CompletableFuture.failedFuture(new RuntimeException("rt")).handle((i,e)->{
            System.out.println("exception:"+e.getMessage());
            return 0;
        }).thenAccept(i->System.out.println("failed future whith:"+i));
        CompletableFuture.completedStage(1).thenAccept(i->System.out.println("complete stage with:"+i));
        CompletableFuture.failedStage(new RuntimeException("rt")).handle((i,e)->{
            System.out.println("exception:"+e.getMessage());
            return 0;
        }).thenAccept(i->System.out.println("failed stage whith:"+i));
    }
}
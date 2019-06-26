package pers.bruce.javafeatures._9features;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.time.ZoneId;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 本地化进程
 * @author Bruce.Tong
 * @date 2019/6/27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EnhancedProcessTests {

    /**
     * @description 测试管理自身进程
     * @author Bruce.Tong
     * @date 2019/6/27
     */
    @Test
    public void testGetMyself() {
        RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
        String[] names = runtime.getName().split("@");
        System.out.println("自身进程id是："+names[0]+" 应用名称是："+names[1]);
    }

    /**
     * @description 测试管理其它进程
     * @author Bruce.Tong
     * @date 2019/6/27
     */
    @Test
    public void testManageOther() throws IOException {
        ProcessBuilder pb = new ProcessBuilder("notepad.exe");
        String np = "Not Present";
        Process p = pb.start();
        ProcessHandle.Info info = p.info();
        System.out.printf("pid : %s%n", p.pid());
        System.out.printf("命令名称 : %s%n", info.command().orElse(np));
        System.out.printf("命令行 : %s%n", info.commandLine().orElse(np));
        System.out.printf("启动时间: %s%n",
                info.startInstant().map(i -> i.atZone(ZoneId.systemDefault())
                        .toLocalDateTime().toString()).orElse(np));
        System.out.printf("启动参数 : %s%n",
                info.arguments().map(a -> Stream.of(a).collect(
                        Collectors.joining(" "))).orElse(np));
        System.out.printf("用户 : %s%n", info.user().orElse(np));
    }
}

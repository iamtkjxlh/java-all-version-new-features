package pers.bruce.javafeatures._8features;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * @description 默认方法相关单元测试
 * @author Bruce.Tong
 * @date 2019/6/19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DateTimeApiTests {
    /**
     * @description 测试本地时间
     * @author Bruce.Tong
     * @date 2019/6/19
     */
    @Test
    public void testLocalDateTime() {
        //获取当前的日期时间
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("当前时间：" + currentTime);
        //输出当前日期
        LocalDate currentDate = currentTime.toLocalDate();
        System.out.println("当前日期：" + currentDate);
        //分解时间
        int year = currentDate.getYear();
        Month month = currentDate.getMonth();
        int day = currentDate.getDayOfMonth();
        int hour = currentTime.getHour();
        int minute = currentTime.getMinute();
        int seconds = currentTime.getSecond();
        System.out.println("分解的日期：" + year+"-"+month.getValue()+"-"+day+" "+hour+":"+minute+":"+seconds);
        //单个属性修改时间
        LocalDateTime newDateTime = currentTime.withDayOfMonth(10).withYear(2010);
        System.out.println("修改单个属性的日期：" + newDateTime);
        //用属性构造日期
        LocalDate instanceofDate = LocalDate.of(2010,10,1);
        System.out.println("构造的日期：" + instanceofDate);
        //用属性构造时间
        LocalTime instanceofTime = LocalTime.of(10,23,10);
        System.out.println("构造的时间：" + instanceofTime);
        //用字符串构造日期
        LocalDate strInstanceofDate = LocalDate.parse("2010-01-02");
        System.out.println("字符串构造的日期：" + strInstanceofDate);
        //用字符串构造时间
        LocalTime strInstanceofTime = LocalTime.parse("10:21:10");
        System.out.println("字符串构造的时间：" + strInstanceofTime);
        //用字符串构造完整的日期时间
        LocalDateTime strInstanceofDatetime = LocalDateTime.parse("2010-06-24T09:14:04.273761");
        System.out.println("字符串构造的日期时间（默认格式化方法）：" + strInstanceofDatetime);
        //用字符串构造完整的日期时间
        LocalDateTime strInstanceofDatetime2 = LocalDateTime.parse("2010-06-24 09:14:04.100",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        System.out.println("字符串构造的日期时间（自定义格式化方法）：" + strInstanceofDatetime2);
    }

    /**
     * @description 测试带时区的时间
     * @author Bruce.Tong
     * @date 2019/6/19
     */
    @Test
    public void testZoneDateTime(){
        //根据上海时区创建时间
        ZonedDateTime dateTime = ZonedDateTime.parse("2010-10-01T10:12:10+05:30[Asia/Shanghai]");
        System.out.println("上海时区: " + dateTime);
        //巴黎时区
        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("巴黎时区id: " + id);
        //当前时区
        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("当前时区: " + currentZone);
        //上海时区修改为巴黎时区
        ZonedDateTime parisDateTime = dateTime.withZoneSameInstant(id);
        System.out.println("上海时区修改为巴黎时区: " + parisDateTime);
    }
}

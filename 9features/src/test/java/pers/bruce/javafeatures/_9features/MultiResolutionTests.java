package pers.bruce.javafeatures._9features;

import java.awt.Image;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.imageio.ImageIO;
import java.awt.image.BaseMultiResolutionImage;
import java.awt.image.MultiResolutionImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * 多分辨率图像
 * @author Bruce.Tong
 * @date 2019/7/1
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiResolutionTests {

    /**
     * @description 测试多分辨率图像
     * @author Bruce.Tong
     * @date 2019/7/1
     */
    @Test
    public void testMultiResolution() throws IOException {
        //图片数组
        List<String> imgUrls = List.of("http://www.baidu.com/img/baidu_resultlogo@2.png",
                "http://www.baidu.com/img/bd_logo1.png?qua=high&where=super",
                "http://imgm.gmw.cn/attachement/jpg/site215/20190701/1022512913614917142.jpg");
        List<Image> images = new ArrayList<Image>();
        for(String imgUrl:imgUrls){
            images.add(ImageIO.read(new URL(imgUrl)));
        }
        // 读取所有图片
        MultiResolutionImage multiResolutionImage = new BaseMultiResolutionImage(images.toArray(new Image[0]));
        // 获取图片的所有分辨率
        List<Image> variants = multiResolutionImage.getResolutionVariants();
        System.out.println("Total number of images: " + variants.size());
        for (Image img : variants) {
            System.out.println(img);
        }
        // 根据不同尺寸获取对应的图像分辨率
        Image variant1 = multiResolutionImage.getResolutionVariant(156, 45);
        System.out.printf("\nImage for destination[%d,%d]: [%d,%d]",156, 45, variant1.getWidth(null), variant1.getHeight(null));
        Image variant2 = multiResolutionImage.getResolutionVariant(311, 89);
        System.out.printf("\nImage for destination[%d,%d]: [%d,%d]", 311, 89,variant2.getWidth(null), variant2.getHeight(null));
        Image variant3 = multiResolutionImage.getResolutionVariant(622, 178);
        System.out.printf("\nImage for destination[%d,%d]: [%d,%d]", 622, 178,variant3.getWidth(null), variant3.getHeight(null));
        Image variant4 = multiResolutionImage.getResolutionVariant(300, 300);
        System.out.printf("\nImage for destination[%d,%d]: [%d,%d]", 300, 300,variant4.getWidth(null), variant4.getHeight(null));
    }
}

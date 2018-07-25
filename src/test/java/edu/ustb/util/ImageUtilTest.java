package edu.ustb.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

/**
 * @author 作者 cc E-mail: bluecats2010@163.com
 * @version 创建时间：2017年11月9日 下午5:20:41 类说明
 */
public class ImageUtilTest {
	public static void main(String[] args) throws IOException {
		// 指定文件大小
		Thumbnails
				.of("d://a.jpg")
				.size(600, 400)
				// 加入水印 0.25f是透明度 outputQuality(0.8f)是压缩比
				.watermark(Positions.BOTTOM_RIGHT,
						ImageIO.read(new File("d://watermark.jpg")), 0.25f)
				.outputQuality(0.8f).toFile("d://newa.jpg");

//		System.out.println(UUID.randomUUID().toString().replace("-", ""));

	}
}

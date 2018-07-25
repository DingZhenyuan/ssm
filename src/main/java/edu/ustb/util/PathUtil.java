package edu.ustb.util;

public class PathUtil {
	private static String seperator = System.getProperty("file.separator");

	//依据不同的业务需求，返回项目图片子路径。如将图片分别存储在各自的店面下
	public static String getShopImagePath(long shopId) {
		String imagePath = "/upload/images/item/shop/" + shopId + "/";
		return imagePath.replace("/", seperator);
	}
}

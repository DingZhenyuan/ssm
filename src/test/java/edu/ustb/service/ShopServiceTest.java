package edu.ustb.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.imageio.ImageIO;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import edu.ustb.BaseTest;
import edu.ustb.domain.Area;
import edu.ustb.domain.Shop;
import edu.ustb.domain.ShopCategory;
import edu.ustb.vo.ImageHolder;

public class ShopServiceTest extends BaseTest {
	@Autowired
	@Qualifier("ShopServiceImpl")
	private ShopService shopService;
	@Test
	public void save() throws Exception {
		Shop shop = new Shop();
		Area area = new Area();
		area.setAreaId(2);
		shop.setArea(area);
		
		ShopCategory category = new ShopCategory();
		category.setShopCategoryId(14L);
		shop.setShopCategory(category);
		
		shop.setPhone("158.....");
		shop.setShopAddr("北京市");
		shop.setShopName("landrover");

		ImageHolder holder = new ImageHolder("d:/loud_speaker.png",
				new FileInputStream("d:/a.png"));
		
		this.shopService.save(shop, holder, "D:/sts/Workspaces/.metadata/.plugins/org.eclipse.wst.server.core/tmp2/wtpwebapps/ssm_ustb_02/resources/");
		
		

	}

}

package edu.ustb.mapper;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import edu.ustb.BaseTest;
import edu.ustb.domain.Shop;

public class ShopMapperTest extends BaseTest {
	@Autowired
	@Qualifier("ShopMapper")
	private ShopMapper shopMapper;
	@Test
	public void queryShopListTest() {
		List<Shop> shopList = this.shopMapper.queryShopList(1L);
		for (Shop shop : shopList) {
			System.out.println(shop.getShopName());
			System.out.println(shop.getArea().getAreaName());
			System.out.println(shop.getShopCategory().getShopCategoryName());
			System.out.println(shop.getOwner().getName());
			System.out.println("=======================");
		}
	}
	@Test
	public void updateShopImg(){
		long shopId = 36;
		String shopImg = "测试用图片";
		int i = this.shopMapper.updateShopImg(shopId, shopImg);
		Assert.assertEquals(1, i);
	}

}

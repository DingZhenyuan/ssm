package edu.ustb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import edu.ustb.BaseTest;
import edu.ustb.domain.ShopCategory;

public class ShopCategoryMapperTest extends BaseTest{
	@Autowired@Qualifier("ShopCategoryMapper")
	private ShopCategoryMapper shopCategoryMapper;
	@Test
	public void queryShopCategoryTest(){
		List<ShopCategory> ShopCategoryList = this.shopCategoryMapper.queryShopCategory();
		for (ShopCategory shopCategory : ShopCategoryList) {
			System.out.println(shopCategory.getShopCategoryName());
		}
	}
}

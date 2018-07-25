package edu.ustb.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import edu.ustb.BaseTest;
import edu.ustb.domain.ProductCategory;
import edu.ustb.domain.Shop;

public class ProductCateServiceTest extends BaseTest {
	
	@Autowired
	@Qualifier("ProductCateServiceImpl")
	private ProductCategoryService productCategoryService;
	@Test
	public void save() throws Exception {
		ProductCategory productCategory = new ProductCategory();
		productCategory.setProductCategoryName("运动器材");
		productCategory.setPriority(0);
		productCategory.setShopId(29L);
		
		this.productCategoryService.save(productCategory);
	}
}

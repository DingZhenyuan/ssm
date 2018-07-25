package edu.ustb.mapper;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import edu.ustb.BaseTest;
import edu.ustb.domain.ProductCategory;

public class ProductCateMapperTest extends BaseTest {
	@Autowired
	@Qualifier("ProductCategoryMapper")
	private ProductCategoryMapper productCategoryMapper;

	@Test
	public void queryPCTest() {
		List<ProductCategory> productCategoryList = this.productCategoryMapper.queryProductCategory(29L);
		
		for (ProductCategory productCategory : productCategoryList) {
			System.out.println(productCategory.getProductCategoryName());
			System.out.println("===============================");
		}
	}
	
	@Test
	public void queryById() {
		ProductCategory productCategory = this.productCategoryMapper.queryById(7L);
		System.out.println(productCategory.getProductCategoryName());
		System.out.println(productCategory.getPriority());
	}
}

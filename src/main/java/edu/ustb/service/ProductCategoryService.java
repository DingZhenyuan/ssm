package edu.ustb.service;

import java.util.List;

import edu.ustb.domain.ProductCategory;
import edu.ustb.exception.ShopException;

public interface ProductCategoryService {
	List<ProductCategory> queryProductCategory(long shopId);
	
	/**
	 * 添加商品类型的方法
	 * @param ProductCategory商品类型
	 * @throws Exception 
	 */
	public void save(ProductCategory productCategory)throws Exception;
	
	public ProductCategory queryById(long productCategoryId);
	
	public int updateProductCategory(ProductCategory productCategory);
}

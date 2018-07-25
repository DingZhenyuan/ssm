package edu.ustb.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.ustb.domain.ProductCategory;

@Repository("ProductCategoryMapper")
public interface ProductCategoryMapper {
	
	/**
	 * 增加商品类型的功能
	 * @param shop
	 * @return
	 */
	int insertProductCategory(ProductCategory productCategory);
	/**
	 * 根据传入的查询条件返回商品类型列表
	 * @return
	 */
	List<ProductCategory> queryProductCategory(long shopId);
	
	/**
	 * 更新商品类型的功能
	 * @param productCategory商品类型
	 * @return
	 */
	int updateProductCategory(ProductCategory productCategory);
	
	/**
	 * 按编号查询商品类型
	 * @param shopId 商品类型编号
	 * @return 商品类型对象
	 */
	ProductCategory queryById(long productCategoryId);
}
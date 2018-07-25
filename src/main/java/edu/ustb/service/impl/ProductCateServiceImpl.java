package edu.ustb.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.ustb.domain.PersonInfo;
import edu.ustb.domain.ProductCategory;
import edu.ustb.domain.Shop;
import edu.ustb.exception.ShopException;
import edu.ustb.mapper.ProductCategoryMapper;
import edu.ustb.service.ProductCategoryService;
import edu.ustb.util.ImageUtil;
import edu.ustb.util.PathUtil;
import edu.ustb.vo.ImageHolder;

@Service("ProductCateServiceImpl")
public class ProductCateServiceImpl implements ProductCategoryService {

	@Autowired
	@Qualifier("ProductCategoryMapper")
	private ProductCategoryMapper productCategoryMapper;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<ProductCategory> queryProductCategory(long shopId) {
		return productCategoryMapper.queryProductCategory(shopId);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void save(ProductCategory productCategory) throws Exception {
		productCategory.setCreateTime(new Date());
		List<ProductCategory> productCategoryList = queryProductCategory(productCategory.getShopId());
		for (ProductCategory productCategory1 : productCategoryList) {
			if (productCategory1.getProductCategoryName().equals(productCategory.getProductCategoryName())){
				throw new Exception("保存商品类型错误！");
			}
		}
		int i = this.productCategoryMapper.insertProductCategory(productCategory);
		
		if (i == 0) {
			throw new Exception("保存商品类型错误！");
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public ProductCategory queryById(long productCategoryId) {
		return this.productCategoryMapper.queryById(productCategoryId);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={Exception.class})
	public int updateProductCategory(ProductCategory productCategory) {
		return this.productCategoryMapper.updateProductCategory(productCategory);
	}
}

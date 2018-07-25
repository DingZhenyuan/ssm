package edu.ustb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import edu.ustb.domain.Shop;
import edu.ustb.domain.ShopCategory;

@Repository("ShopCategoryMapper")
public interface ShopCategoryMapper {
	/**
	 * 根据传入的查询条件返回店铺类别列表
	 * 
	 * @param shopCategoryCondition
	 * @return
	 */
	List<ShopCategory> queryShopCategory();
}

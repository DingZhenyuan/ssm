package edu.ustb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.ustb.domain.ShopCategory;
import edu.ustb.mapper.ShopCategoryMapper;
import edu.ustb.service.ShopCategoryService;

@Service("ShopCategoryServiceImpl")
public class ShopCategoryServiceImpl implements ShopCategoryService {
	@Autowired
	@Qualifier("ShopCategoryMapper")
	private ShopCategoryMapper shopCategoryMapper;
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<ShopCategory> queryShopCategory() {
		return shopCategoryMapper.queryShopCategory();
	}
}

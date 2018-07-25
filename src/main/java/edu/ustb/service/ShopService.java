package edu.ustb.service;

import java.util.List;

import edu.ustb.domain.Shop;
import edu.ustb.exception.ShopException;
import edu.ustb.vo.ImageHolder;

public interface ShopService {
	/**
	 * 注册店铺的业务方法
	 * @param shop 店铺
	 * @param imageHolder 上传文件对象
	 * @param resourcesPath 站点根目录的物理路径位置
	 * @throws ShopException 注册失败时抛出
	 */
	public void save(Shop shop, ImageHolder imageHolder, String resourcesPath)
			throws ShopException;

	public List<Shop> queryShopList(Long userId);
	
	public Shop queryByShopId(Long shopId);
	
	public int updateShop(Shop shop);
	
	
	
}











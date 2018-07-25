package edu.ustb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import edu.ustb.domain.Shop;

@Repository("ShopMapper")
public interface ShopMapper {
	/**
	 * 更新店铺信息的方法
	 * @param shop 店铺对象
	 * @return
	 */
	int updateShop(Shop shop);
	/**
	 * 增加店铺功能
	 * @param shop
	 * @return
	 */
	int insertShop(Shop shop);
	/**
	 * 修改店铺图片方法
	 * @param shopId 编号
	 * @param shopImg 图片路径
	 * @return 更新几行
	 */
	int updateShopImg(@Param("shopId")long shopId,@Param("shopImg")String shopImg);
	/**
	 * 按编号查询功能
	 * @param shopId 店铺编号
	 * @return 店铺对象
	 */
	Shop queryByShopId(long shopId);
	/**
	 * 店铺查询功能
	 * @return
	 */
	List<Shop> queryShopList(Long userId);
}

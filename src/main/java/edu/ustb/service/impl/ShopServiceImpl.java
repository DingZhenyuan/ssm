package edu.ustb.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.ustb.domain.PersonInfo;
import edu.ustb.domain.Shop;
import edu.ustb.exception.ShopException;
import edu.ustb.mapper.ShopMapper;
import edu.ustb.service.ShopService;
import edu.ustb.util.ImageUtil;
import edu.ustb.util.PathUtil;
import edu.ustb.vo.ImageHolder;

@Service("ShopServiceImpl")
public class ShopServiceImpl implements ShopService {
	@Autowired
	@Qualifier("ShopMapper")
	private ShopMapper shopMapper;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={Exception.class})
	public int updateShop(Shop shop) {
		//设置最后修改时间
		shop.setLastEditTime(new Date());
		return this.shopMapper.updateShop(shop);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={ShopException.class})
	public void save(Shop shop, ImageHolder imageHolder, String resourcesPath)
			throws ShopException {
		// 1 实现保存店铺信息到数据库，获得店铺编号（自动增长）。
		// 临时模拟用户1的店铺
		PersonInfo owner = new PersonInfo();
		owner.setUserId(1L);
		shop.setOwner(owner);

		shop.setCreateTime(new Date());
		shop.setLastEditTime(new Date());
		shop.setEnableStatus(0);

		int i = this.shopMapper.insertShop(shop);
		if (i == 0) {
			throw new ShopException("保存店铺错误！");
		}
		// 2 根据店铺编号创建目录。保存这个店铺的图片（文件操作）
		// 获取店铺目录
		String dest = PathUtil.getShopImagePath(shop.getShopId());
		// 3 上传图片，获得图片的名称（上传的图片都会重命名）。
		String shopImgAddr = ImageUtil.generateThumbnail(imageHolder, dest,
				resourcesPath);
		// 4 更新店铺的图片字段。
		i = this.shopMapper.updateShopImg(shop.getShopId(), shopImgAddr);
		if(i==0){
			throw new ShopException("更新图片失败！");
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Shop> queryShopList(Long userId) {
		return this.shopMapper.queryShopList(userId);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Shop queryByShopId(Long shopId) {
		// TODO Auto-generated method stub
		return this.shopMapper.queryByShopId(shopId);
	}

}

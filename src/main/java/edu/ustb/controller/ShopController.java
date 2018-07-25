package edu.ustb.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edu.ustb.domain.Area;
import edu.ustb.domain.PersonInfo;
import edu.ustb.domain.Shop;
import edu.ustb.domain.ShopCategory;
import edu.ustb.exception.ShopException;
import edu.ustb.service.AreaService;
import edu.ustb.service.ShopCategoryService;
import edu.ustb.service.ShopService;
import edu.ustb.service.impl.ShopServiceImpl;
import edu.ustb.util.ImageUtil;
import edu.ustb.util.PathUtil;
import edu.ustb.vo.ImageHolder;

@RequestMapping("/shop")
@Controller("ShopController")
@MultipartConfig
public class ShopController {
	@Autowired
	@Qualifier("ShopServiceImpl")
	private ShopService shopService;
	@Autowired
	@Qualifier("AreaServiceImpl")
	private AreaService areaService;
	@Autowired
	@Qualifier("ShopCategoryServiceImpl")
	private ShopCategoryService shopCategoryService;

	@RequestMapping(value = "/updateshop", method = { RequestMethod.POST })
	public String updateShop(Shop shop, Model model) {
		try {
			this.shopService.updateShop(shop);
			return "redirect:/shop/queryshoplist";
		} catch (Exception e) {
			e.printStackTrace();
			// model.addAttribute("shopId",shop.getShopId());
			return "redirect:/shop/toupdate?shopId=" + shop.getShopId();
		}
	}

	@RequestMapping("/toupdate")
	public String toUpdate(Long shopId, Model model) {
		Shop shop = this.shopService.queryByShopId(shopId);
		model.addAttribute("shop", shop);
		List<Area> areaList = this.areaService.queryArea();
		List<ShopCategory> categoryList = this.shopCategoryService
				.queryShopCategory();
		model.addAttribute("areaList", areaList);
		model.addAttribute("categoryList", categoryList);
		return "shop/update";
	}

	@RequestMapping("/save")
	public String save(Shop shop,
			@RequestParam("upShopImg") MultipartFile shopImg,
			HttpServletRequest request) throws IOException {
		HttpSession session = request.getSession();
		PersonInfo personInfo = (PersonInfo) session.getAttribute("person");
		shop.setOwner(personInfo);

		shop.setCreateTime(new Date());
		shop.setLastEditTime(new Date());
		shop.setEnableStatus(0);// 审核中

		// 封装文件上传信息
		ImageHolder imageHolder = new ImageHolder(
				shopImg.getOriginalFilename(), shopImg.getInputStream());
		// 获取resources物理位置
		String resourcesPath = request.getServletContext().getRealPath(
				"/resources");
		try {
			// 调用业务实现注册店铺
			shopService.save(shop, imageHolder, resourcesPath);
			return "redirect:/shop/queryshoplist";
		} catch (ShopException e) {
			e.printStackTrace();
			return "redirect:/shop/tosave";
		}
	}

	@RequestMapping("/tosave")
	public String toSave(Model model) {
		List<Area> areaList = this.areaService.queryArea();
		List<ShopCategory> categoryList = this.shopCategoryService
				.queryShopCategory();
		model.addAttribute("areaList", areaList);
		model.addAttribute("categoryList", categoryList);
		return "shop/save";
	}

	@RequestMapping("/queryshoplist")
	public String queryShopList(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		PersonInfo personInfo = (PersonInfo) session.getAttribute("person");
		Long personId = personInfo.getUserId();
		List<Shop> shopList = this.shopService.queryShopList(personId);
		model.addAttribute("shopList", shopList);
		return "shop/show";
	}

}

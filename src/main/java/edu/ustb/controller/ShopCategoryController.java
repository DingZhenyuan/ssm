package edu.ustb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ustb.domain.PersonInfo;
import edu.ustb.domain.Shop;
import edu.ustb.service.ShopService;

@Controller
@RequestMapping("/shopcategory")
public class ShopCategoryController {
	@Autowired@Qualifier("ShopServiceImpl")
	private ShopService shopService;
	
	@RequestMapping("/queryshoplist")
	public String queryShopList(Model model,HttpServletRequest request) {
		HttpSession session = request.getSession();
		PersonInfo personInfo = (PersonInfo) session.getAttribute("person");
		Long personId = personInfo.getUserId();
		
		List<Shop> shopList = this.shopService.queryShopList(personId);
		model.addAttribute("shopList", shopList);
		return "shopcategory/shopshow";
	}
}

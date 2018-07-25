package edu.ustb.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

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
import edu.ustb.domain.ProductCategory;
import edu.ustb.domain.Shop;
import edu.ustb.domain.ShopCategory;
import edu.ustb.exception.ShopException;
import edu.ustb.service.ProductCategoryService;
import edu.ustb.vo.ImageHolder;

@Controller
@RequestMapping("/productcategory")
@MultipartConfig
public class productCategoryController {
	@Autowired@Qualifier("ProductCateServiceImpl")
	private ProductCategoryService productCategoryService;
	
	@RequestMapping("/queryproductCatelist")
	public String queryProductCateList(Model model, Long shopId) {
		List<ProductCategory> productCategoryList = this.productCategoryService.queryProductCategory(shopId);
		model.addAttribute("productCategoryList", productCategoryList);
		model.addAttribute("thisShopId", shopId);
		return "productcategory/show";
	}
	
	@RequestMapping("/tosaveproductcate")
	public String toSaveProductCate(Long shopId, Model model) {
		model.addAttribute("thisShopId", shopId);
		return "productcategory/save";
	}
	
	@RequestMapping("/saveproductcate")
	public String saveProductCate(Long shopId, ProductCategory productCategory) throws Exception {
		productCategory.setCreateTime(new Date());
		productCategory.setShopId(shopId);
		try {
			productCategoryService.save(productCategory);
			return "redirect:/productcategory/queryproductCatelist?shopId=" + shopId;
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/productcategory/tosaveproductcate?shopId=" + shopId;
		}
	}
	
	@RequestMapping("/toupdateproductcate")
	public String toUpdateProductCate(Long productCategoryId, Model model) {
		ProductCategory productCategory = this.productCategoryService.queryById(productCategoryId);
		model.addAttribute("productCategory", productCategory);
		
		return "productcategory/update";
		
	}
	
	@RequestMapping("/updateproductcate")
	public String updateProductCate(ProductCategory productCategory, long shopId) {
		try{
			this.productCategoryService.updateProductCategory(productCategory);
			return "redirect:/productcategory/queryproductCatelist?shopId=" + shopId;
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/productcategory/toupdateproductcate?shopId=" + shopId;
		}
	}
	
}

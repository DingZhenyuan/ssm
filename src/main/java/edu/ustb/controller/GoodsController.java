package edu.ustb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	@RequestMapping("/show")
	public String show(){
		return "goods/show";
	}
}

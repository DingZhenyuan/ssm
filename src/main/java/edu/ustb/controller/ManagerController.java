package edu.ustb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/manager")
@Controller
public class ManagerController {
	@RequestMapping("/login")
	public String login(){
		return "adminlogin";
	}
	@RequestMapping("/center")
	public String center(){
		return "center";
	}
	@RequestMapping("/down")
	public String down(){
		return "down";
	}
	@RequestMapping("/left")
	public String left(){
		return "left";
	}
	@RequestMapping("/main")
	public String main(){
		return "main";
	}
	@RequestMapping("/middel")
	public String middel(){
		return "middel";
	}
	@RequestMapping("/top")
	public String top(){
		return "top";
	}
	@RequestMapping("/welcome")
	public String welcome(){
		return "welcome";
	}
}

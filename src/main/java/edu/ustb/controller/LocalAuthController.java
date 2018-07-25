package edu.ustb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ustb.domain.LocalAuth;
import edu.ustb.exception.LoginException;
import edu.ustb.service.LocalAuthService;

@Controller
@RequestMapping("/localauth")
public class LocalAuthController {
	@Autowired
	@Qualifier("LocalAuthServiceImpl")
	private LocalAuthService localAuthService;

	@RequestMapping("/islogin")
	public String isLogin(String username, String password,
			Model model,HttpServletRequest request) {
		try {
			LocalAuth auth = this.localAuthService.isLogin(username, password);
			HttpSession session = request.getSession();
			session.setAttribute("person", auth.getPersonInfo());
			return "redirect:/manager/main";
		} catch (LoginException e) {
			e.printStackTrace();
			model.addAttribute("error",e.getMessage());
			return "adminlogin";
		}
	}
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request){
		request.getSession().removeAttribute("person");
		return "adminlogin";
	}
}

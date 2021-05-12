package edu.zstu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zstu.enity.UserEnity;
import edu.zstu.service.UserService;

@Controller
@RequestMapping(value="/")
public class UrlController{

	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(){
		return "index";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register(){
		return "register";
	}
	
	@RequestMapping(value = "activity", method = RequestMethod.GET)
	public String activity(){
		return "activity";
	}
	 
	@RequestMapping(value = "food", method = RequestMethod.GET)
	public String food(){
		return "food";
	}
	
	@RequestMapping(value = "food-detail", method = RequestMethod.GET)
	public String food_detail(){
		return "food-detail";
	}
	
	@RequestMapping(value = "msg", method = RequestMethod.GET)
	public String msg(Model model){
		String[] a={"a","b","c"};
		model.addAttribute("message", a);
		return "showMessage";
	}
	
	@Autowired
	private UserService userService;

	
	/**
	 * 检查用户名是否存在
	 * return boolean
	 * 存在返回false，不存在返回true
	 *  */
	@RequestMapping(value = "checkUsername", method = RequestMethod.GET)
	public @ResponseBody boolean checkUsername(@RequestParam(value="Username")String Username ){
		UserEnity user = this.userService.findByUserName(Username);
		if(user !=null){
			return false;
		}
		return  true;
	}
	
	
	/*
	 * 写入用户注册数据(传参)
	 * return string
	 * */
	@RequestMapping(value = "regUser", method = RequestMethod.POST)
	public @ResponseBody String regUser(String Username,String Password){
		UserEnity user = this.userService.findByUserName(Username);
		if(user !=null){
			return "{\"Success\":false,\"Msg\":\"该邮箱已被注册\"}";
		}
		UserEnity oUser = new UserEnity();
		oUser.setUsername(Username);
		oUser.setPassword(Password);
		this.userService.regUser(oUser);
		return "{\"Success\":true,\"Msg\":\"邮箱注册成功\"}";
	}
}








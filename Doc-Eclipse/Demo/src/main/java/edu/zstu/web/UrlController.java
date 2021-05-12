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
	
	@RequestMapping(value = "food", method = RequestMethod.GET)
	public String food(){
		return "food";
	}
	
	@RequestMapping(value = "food-detail", method = RequestMethod.GET)
	public String food_detail(){
		return "food-detail";
	}
	
	@RequestMapping(value = "activity", method = RequestMethod.GET)
	public String activity(){
		return "activity";
	}
	 
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register(){
		return "register";
	}

	
	// just for test
	@RequestMapping(value = "msg", method = RequestMethod.GET)
	public String msg(Model model){
		String[] a={"a","b","c"};
		model.addAttribute("message", a);
		return "showMessage";
	}
	
	

}








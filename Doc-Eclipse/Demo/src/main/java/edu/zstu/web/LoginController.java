package edu.zstu.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springside.modules.security.utils.Digests;
//import org.springside.modules.utils.Encodes;

import edu.zstu.enity.UserEnity;
import edu.zstu.service.ShiroDbRealm.ShiroUser;
import edu.zstu.service.UserService;

@Controller
@RequestMapping(value="/")
public class LoginController {

	@Autowired
	private UserService userService;
	
//	@RequestMapping(method = RequestMethod.GET)
//	public String login(){
//		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
//		if(user!=null){
//			SecurityUtils.getSubject().logout();
//		}
//		return "login";
//	}
//	
//	@RequestMapping(method = RequestMethod.POST)
//	public String login(@RequestParam String username,Model model){
//		model.addAttribute("username", username);
//		return "login";
//	}
	
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String loginConfirm(HttpServletRequest request) throws Exception {
		
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		System.out.println("exceptionClassName: "+exceptionClassName);
		if (exceptionClassName != null){
			if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
				request.setAttribute("errorMsg", "用户名不存在");
			} else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
				request.setAttribute("errorMsg", "用户名/密码不正确");
			}else {
				throw new Exception();
			}
		
		}
		// 此方法不处理登陆成功（认证成功），shiro认证成功会自动跳转到上一个请求路径
		request.setAttribute("username", request.getParameter("username"));
		// 登陆失败返还到login页面
		return "login";
	}
	
	
		
	/*
	 * 获取当前登录用户
	 * */
	@RequestMapping(value = "getCurrUser", method = RequestMethod.GET)
	@ResponseBody 
	public String getCurrUser(){
		UserEnity currUser = userService.getCurrUser();
		if(currUser == null){
			return "";
		}
		return currUser.getUsername();
	}
	
	
	/*
	 * 验证用户密码
     * return boolean
	 * 正确返回true，错误返回false
	 * */
//	@RequestMapping(value = "checkPassword", method = RequestMethod.POST)
//	public @ResponseBody boolean checkPassword(String Username,String Password){
//		UserEnity user = this.userService.findByUserName(Username);
//		if(user == null){
//			return false;
//		}
//		String dbPassword = user.getPassword();
//		String salt = user.getSalt();
//		byte[] salts = Encodes.decodeHex(salt);
//		byte[] hashPassword = Digests.sha1(Password.getBytes(),salts , 1024); 
//		String oPassword = Encodes.encodeHex(hashPassword);
//		if(oPassword != dbPassword){
//			return false;
//		}
//		return true;
//	}

}

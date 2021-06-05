package edu.zstu.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.security.utils.Digests;
import org.springside.modules.utils.Encodes;

import edu.zstu.entity.FoodCollectEntity;
import edu.zstu.entity.UserEntity;
import edu.zstu.service.FoodCollectService;
import edu.zstu.service.UserService;

@Controller
public class BackController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private FoodCollectService foodCollectService;
	
	@RequestMapping(value = "back", method = RequestMethod.GET)
	public String back()throws Exception{
		return "back";
	}

	
	@RequestMapping(value="collectedFoods",method = RequestMethod.GET)
	public @ResponseBody Boolean getCollectedFoods(Model model){
		UserEntity user = this.userService.getCurrUser();
		if(user!=null){
			List<FoodCollectEntity> collectList = this.foodCollectService.findByUser(user);
			if(collectList != null && collectList.size() > 0){
				model.addAttribute("collectList", collectList);
//				System.out.println("collects have been saved with size "+ collectList.size());
				return true;
			}
			return false;
		}
		return false;
	}
	
	
	@RequestMapping(value="modifyPassword",method = RequestMethod.POST)
	public @ResponseBody Boolean modifyPassword
	(
				/*@RequestParam(value="email") String username,*/
				/*@RequestParam(value="password-old")*/ String oldPassword,
				/*@RequestParam(value="password-new")*/ String newPassword
				/*@RequestParam(value="password-new-confirm") String newPasswordConfirm*/
	){
		UserEntity user = this.userService.getCurrUser();
//		if(username == user.getUsername()){
			String encodeOldPassword1 = user.getPassword();
			String salt = user.getSalt();
			byte[] salts = Encodes.decodeHex(salt);
			
			byte[] hashOldPassword = Digests.sha1(oldPassword.getBytes(), salts , 1024); 
			String encodeOldPassword2 = Encodes.encodeHex(hashOldPassword);
			System.out.println("encodeOldPassword1: "+encodeOldPassword1 + "\nencodeOldPassword2: " + encodeOldPassword2);
			if(encodeOldPassword1.equals(encodeOldPassword2)){
				byte[] hashNewPassword= Digests.sha1(newPassword.getBytes(), salts, 1024); 
				String encodeNewPassword = Encodes.encodeHex(hashNewPassword);
				user.setPassword(encodeNewPassword);
				user.setRemark("存在修改记录");
				userService.save(user);
				return true;
			}
//		}
		
		return false;
		
	}
}

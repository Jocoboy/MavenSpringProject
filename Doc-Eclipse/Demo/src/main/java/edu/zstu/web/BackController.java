package edu.zstu.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
}

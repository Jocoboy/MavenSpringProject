package edu.zstu.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.zstu.entity.FoodCollectEntity;
import edu.zstu.entity.FoodEntity;
import edu.zstu.entity.UserEntity;
import edu.zstu.service.FoodCollectService;
import edu.zstu.service.FoodService;
import edu.zstu.service.UserService;

@Controller
public class FoodDetailController {
	
	@Autowired
	private FoodService foodService;
	@Autowired
	private UserService userService;
	@Autowired
	private FoodCollectService foodCollectService;
	
	@RequestMapping(value="/foodDetail")
	public String foodDetail(@RequestParam(value="id")Long id,Model model){
		if(id!=null & id.longValue()!=0){
			FoodEntity food = this.foodService.findOne(id);
			if(food!=null){
				model.addAttribute("food",food);
				UserEntity user = this.userService.getCurrUser();
				if(user!=null){
					List<FoodCollectEntity> collects = this.foodCollectService.findByUserAndFood(user, food);
					if(collects!=null & collects.size() >0){
						model.addAttribute("collectFlag", true);
					}else{
						model.addAttribute("collectFlag", false);
					}	
				}else{
					model.addAttribute("collectFlag", false);
				}
			}
		}
		return "food-detail";
	}
}

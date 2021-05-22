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
	
	@RequestMapping(value="/food-detail")
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
	
	@RequestMapping(value="foodLikes",method = RequestMethod.GET)
	public @ResponseBody Boolean foodLikes(@RequestParam("id") Long id){
		FoodEntity food = this.foodService.findOne(id);
		if(food!=null){
			food.setLikes(food.getLikes()+1);
			this.foodService.save(food);
			return true;
		}
		return false;
	}
	
	@RequestMapping(value="addCollect",method = RequestMethod.GET)
	public @ResponseBody Boolean addCollect(@RequestParam("id") Long id){
		UserEntity user = this.userService.getCurrUser();
		if(user!=null){
			FoodEntity  food = this.foodService.findOne(id);
			if(food!=null){
				FoodCollectEntity collect = new FoodCollectEntity();
				collect.setFood(food);
				collect.setUser(user);
				this.foodCollectService.save(collect);
				return true;
			}
		}
		return false;
	}
	
	@RequestMapping(value="cancelCollect",method = RequestMethod.GET)
	public @ResponseBody Boolean cancelCollect(@RequestParam("id") Long id){
		UserEntity user = this.userService.getCurrUser();
		if(user!=null){
			FoodEntity food = this.foodService.findOne(id);
			if(food!=null){
				List<FoodCollectEntity> collectList = this.foodCollectService.findByUserAndFood(user, food);
				this.foodCollectService.delete(collectList.get(0).getId());
				return true;
			}
		}
		return false;
	}
	
}

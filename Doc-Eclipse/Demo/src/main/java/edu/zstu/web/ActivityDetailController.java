package edu.zstu.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zstu.entity.ActivityReserveEntity;
import edu.zstu.entity.FoodActivityEntity;
import edu.zstu.entity.FoodCollectEntity;
import edu.zstu.entity.FoodEntity;
import edu.zstu.entity.UserEntity;
import edu.zstu.service.ActivityReserveService;
import edu.zstu.service.FoodActivityService;
import edu.zstu.service.UserService;

@Controller
public class ActivityDetailController {

	@Autowired
	private FoodActivityService activityService;
	
	@Autowired
	private UserService userService;
	@Autowired
	private ActivityReserveService activityReserveService;
	
	
	@RequestMapping(value="/activity-detail")
	public String activityDetail(@RequestParam(value="id")Long id,Model model){
		if(id!=null & id.longValue()!=0){
			FoodActivityEntity activity = this.activityService.findOne(id);
			if(activity!=null){
				model.addAttribute("activity",activity);
				UserEntity user = this.userService.getCurrUser();
				if(user!=null){
					List<ActivityReserveEntity> reserves = this.activityReserveService.findByUserAndActivity(user, activity);
					if(reserves!=null & reserves.size() >0){
						model.addAttribute("reserveFlag", true);
					}else{
						model.addAttribute("reserveFlag", false);
					}	
				}else{
					model.addAttribute("reserveFlag", false);
				}
			}
		}
		return "activity-detail";
	}
	
	
	@RequestMapping(value="addReserve",method = RequestMethod.GET)
	public @ResponseBody Boolean addReserve(@RequestParam("id") Long id){
		UserEntity user = this.userService.getCurrUser();
		if(user!=null){
			FoodActivityEntity activity = this.activityService.findOne(id);
			if(activity!=null){
				ActivityReserveEntity reserve = new ActivityReserveEntity();
				reserve.setActivity(activity);
				reserve.setUser(user);
				this.activityReserveService.save(reserve);
				return true;
			}
		}
		return false;
	}
	
	@RequestMapping(value="cancelReserve",method = RequestMethod.GET)
	public @ResponseBody Boolean cancelReserve(@RequestParam("id") Long id){
		UserEntity user = this.userService.getCurrUser();
		if(user!=null){
			FoodActivityEntity activity = this.activityService.findOne(id);
			if(activity!=null){
				List<ActivityReserveEntity> reserveList = this.activityReserveService.findByUserAndActivity(user, activity);
				this.activityReserveService.delete(reserveList.get(0).getId());
				return true;
			}
		}
		return false;
	}
}

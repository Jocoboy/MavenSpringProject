package edu.zstu.web;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zstu.entity.FoodEntity;
import edu.zstu.entity.UserEntity;
import edu.zstu.entity.ActivityReserveEntity;
import edu.zstu.entity.FoodActivityEntity;
import edu.zstu.entity.FoodCollectEntity;
import edu.zstu.json.JsonReaderResponse;
import edu.zstu.service.ActivityReserveService;
import edu.zstu.service.FoodActivityService;
import edu.zstu.service.FoodCollectService;
import edu.zstu.service.FoodService;
import edu.zstu.service.UserService;

@Controller
public class QueryController { 
	
	@Autowired
	private FoodService foodService;
	
	@Autowired
	private FoodActivityService activityService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ActivityReserveService activityReserveService;
	
	@Autowired
	private FoodCollectService foodCollectService;
	
	@RequestMapping(value="getFoodList",method=RequestMethod.GET)
	public @ResponseBody JsonReaderResponse<FoodEntity> getFoodList
	(
			@RequestParam(value="pageNumber",defaultValue="1") int pageNumber,
			@RequestParam(value="pageSize",defaultValue="5") int pageSize,
			@RequestParam(value="sort",defaultValue="") String sort,
			@RequestParam(value="foodName",defaultValue="") String foodName,
			@RequestParam(value="deployUser",defaultValue="") String deployUser,
			@RequestParam(value="startDate",defaultValue="") String startDate,
			@RequestParam(value="endDate",defaultValue="") String endDate
	) throws ParseException{
		
		Map<String,Object> searchParams = new HashMap<String,Object>();
		if(StringUtils.isNotBlank(foodName)){
			searchParams.put("LIKE_foodName", foodName);
		}
		if(StringUtils.isNotBlank(deployUser)){
			searchParams.put("LIKE_user.Username", deployUser);
		}
		if(StringUtils.isNotBlank(startDate)){
			searchParams.put("GTE_deployDate", startDate);
		}
		if(StringUtils.isNotBlank(endDate)){
			searchParams.put("LT_deployDate", endDate);
		}
		
		Page<FoodEntity> list = foodService.getList(searchParams, pageNumber, pageSize, sort, FoodEntity.class);
		return new JsonReaderResponse<FoodEntity>(list,pageSize,pageNumber);
		
	}
	
	
	@RequestMapping(value="getActivityList",method=RequestMethod.GET)
	public @ResponseBody JsonReaderResponse<FoodActivityEntity> getActivityList
	(
			@RequestParam(value="pageNumber",defaultValue="1") int pageNumber,
			@RequestParam(value="pageSize",defaultValue="5") int pageSize,
			@RequestParam(value="endDate",defaultValue="2099-12-31") String endDate
	) throws ParseException{
		
		Map<String,Object> searchParams = new HashMap<String,Object>();
		searchParams.put("LT_endDate", endDate);
		Page<FoodActivityEntity> list = activityService.getList(searchParams, pageNumber, pageSize, "", FoodActivityEntity.class);
//		System.out.println("list size : "+list.getSize());
		return new JsonReaderResponse<FoodActivityEntity>(list,pageSize,pageNumber);
	}
	
	@RequestMapping(value="getReserveList",method=RequestMethod.GET)
	public @ResponseBody JsonReaderResponse<ActivityReserveEntity> getReserveList
	(
			@RequestParam(value="pageNumber",defaultValue="1") int pageNumber,
			@RequestParam(value="pageSize",defaultValue="5") int pageSize

	) throws ParseException{
		Map<String,Object> searchParams = new HashMap<String,Object>();
		UserEntity user = this.userService.getCurrUser();
		searchParams.put("EQ_user.id",user.getId().toString());
		Page<ActivityReserveEntity> list = activityReserveService.getList(searchParams, pageNumber, pageSize, "", ActivityReserveEntity.class);
		return new JsonReaderResponse<ActivityReserveEntity>(list,pageSize,pageNumber);
	}
	
	@RequestMapping(value="getCollectList",method=RequestMethod.GET)
	public @ResponseBody JsonReaderResponse<FoodCollectEntity> getCollectList
	(
			@RequestParam(value="pageNumber",defaultValue="1") int pageNumber,
			@RequestParam(value="pageSize",defaultValue="5") int pageSize

	) throws ParseException{
		Map<String,Object> searchParams = new HashMap<String,Object>();
		UserEntity user = this.userService.getCurrUser();
		searchParams.put("EQ_user.id",user.getId().toString());
		Page<FoodCollectEntity> list = foodCollectService.getList(searchParams, pageNumber, pageSize, "", FoodCollectEntity.class);
		return new JsonReaderResponse<FoodCollectEntity>(list,pageSize,pageNumber);
	}
	
}

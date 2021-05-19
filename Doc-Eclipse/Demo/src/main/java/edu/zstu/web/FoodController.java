package edu.zstu.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import edu.zstu.entity.FileAttachEntity;
import edu.zstu.entity.FoodEntity;
import edu.zstu.entity.FoodStepEntity;
import edu.zstu.service.FileAttachService;
import edu.zstu.service.FoodService;
import edu.zstu.service.UserService;

@Controller
@RequestMapping(value="/food")
public class FoodController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private FileAttachService fileAttachService;
	@Autowired
	private FoodService foodService;
	
	@RequestMapping(value = "/deploy", method = RequestMethod.POST)
	public @ResponseBody String handleDeployDatas
	(
			@RequestParam(value="pic")CommonsMultipartFile[] files,
			@RequestParam(value="step_desc")String[] stepsDesc,
			@RequestParam(value="food_name")String foodName,
			@RequestParam(value="food_mat")String foodMat,
			@RequestParam(value="food_stepnum")int stepNum,
			HttpServletRequest request
	) throws IOException{
		
		FoodEntity food = new FoodEntity();
		List<FoodStepEntity> foodStepList = new ArrayList<FoodStepEntity>();
		//循环处理上传文件FileAttach
		//循环处理美食制作分布数据
		for(int i = 0 ; i < files.length ; i++){
			FileAttachEntity fileAttach = new FileAttachEntity();
			CommonsMultipartFile file = files[i];
			String fileType = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
			fileAttach.setFileType(fileType);;
			String Ext = fileType;
			fileAttach.setExt(Ext);
			String fileName = System.currentTimeMillis()+fileType;
			fileAttach.setFileName(fileName);;
//			String filePath = request.getSession().getServletContext().getRealPath("/public/upload/" + fileName);
			String realServerPath = "/Demo/public/upload/" + fileName;
			String filePath = realServerPath;
			fileAttach.setFilePath(filePath);
			
			String absLocalPath = "D:/common/Documents/Github Repo/Jocoboy/MavenSpringProject/Doc-Eclipse/Demo/src/main/webapp/public/upload/"+ fileName;
			File destFile = new File(absLocalPath);
			FileUtils.copyInputStreamToFile(file.getInputStream(), destFile);
			
			fileAttachService.save(fileAttach);
			
			if(i == 0){
				food.setFileAttach(fileAttach);
			}
			else{
				FoodStepEntity foodStepEnity = new FoodStepEntity();
				foodStepEnity.setStepNo(i);
				foodStepEnity.setStepDesc(stepsDesc[i-1]);
				foodStepEnity.setFileAttach(fileAttach);
				foodStepList.add(foodStepEnity);
			}
		}
		food.setFoodStepList(foodStepList); 
		food.setUser(userService.getCurrUser());
		
		food.setFoodName(foodName);
		food.setDeployDate(new Date());
		food.setFoodMaterial(foodMat);
		food.setSteps(stepNum);
		food.setLikes(0);
		
		foodService.save(food);
		
		//返回页面
		return "redirect:/food";
	}
}

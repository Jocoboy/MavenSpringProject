package edu.zstu.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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

import edu.zstu.enity.FileAttachEnity;
import edu.zstu.enity.FoodEnity;
import edu.zstu.enity.FoodStepEnity;
import edu.zstu.service.FileAttachService;
import edu.zstu.service.FoodService;

@Controller
@RequestMapping(value="/food")
public class FoodController {
	
	@Autowired
	private FileAttachService fileAttachService;
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
		
		//循环处理上传文件FileAttach
		for(int i = 0 ; i < files.length ; i++){
			FileAttachEnity fileAttach = new FileAttachEnity();
			CommonsMultipartFile file = files[i];
			String fileType = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
			fileAttach.setFileType(fileType);;
			String Ext = fileType;
			fileAttach.setExt(Ext);
			String fileName = System.currentTimeMillis()+fileType;
			fileAttach.setFileName(fileName);;
			String filePath = request.getSession().getServletContext().getRealPath("/public/upload/" + fileName);
			fileAttach.setFilePath(filePath);
			
			File destFile = new File(filePath);
			FileUtils.copyInputStreamToFile(file.getInputStream(), destFile);
			
			fileAttachService.save(fileAttach);
		}
		//循环处理美食制作分布数据
		FoodEnity food = new FoodEnity();
		List<FoodStepEnity> foodStepList = new ArrayList<FoodStepEnity>();
		for(int i = 0; i < stepsDesc.length; i++){
			FoodStepEnity foodStepEnity = new FoodStepEnity();
			foodStepEnity.setStepNo(i+1);
			foodStepEnity.setStepDesc(stepsDesc[i]);
			foodStepList.add(foodStepEnity);
		}
		food.setFoodStepList(foodStepList); 
		food.setFoodName(foodName);
		food.setFoodMaterial(foodMat);
		food.setSteps(stepNum);
		
		foodService.save(food);
		
		//返回页面
		return "redirect:/food";
	}
}

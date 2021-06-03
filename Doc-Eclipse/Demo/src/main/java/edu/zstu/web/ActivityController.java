package edu.zstu.web;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import edu.zstu.entity.FileAttachEntity;
import edu.zstu.entity.FoodActivityEntity;
import edu.zstu.entity.MultiActivityFileAttachEntity;
import edu.zstu.service.FileAttachService;
import edu.zstu.service.FoodActivityService;
import edu.zstu.service.UserService;

@Controller
@RequestMapping(value="/activity")
public class ActivityController {

	@Autowired
	private FileAttachService fileAttachService;
	@Autowired
	private FoodActivityService foodActivityService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/deploy", method = RequestMethod.POST)
	public @ResponseBody String handleDeployDatas
	(
			@RequestParam(value="activity_pic")CommonsMultipartFile[] files,
			@RequestParam(value="activity_name")String activityName,
			@RequestParam(value="activity_location")  String activityLocation,
			@RequestParam(value="activity_location_detail")String activityLocationDetail,
			@RequestParam(value="activity_startDate")String startDate ,
			@RequestParam(value="activity_endDate")String endDate,
			@RequestParam(value="activity_description")String activityDescription,
			@RequestParam(value="activity_postnum")int activityPostnum,
			HttpServletRequest request
	) throws IOException{
		
		System.out.println("handleDeployDatas...........");
		
		FoodActivityEntity activity = new FoodActivityEntity();
//		List<FileAttachEntity> fileAttachList = new ArrayList<FileAttachEntity>();
		List<MultiActivityFileAttachEntity> multiFileAttachList = new ArrayList<MultiActivityFileAttachEntity>();
		
		
		for(int i = 0 ; i < files.length ; i++){
			FileAttachEntity fileAttach = new FileAttachEntity();
			CommonsMultipartFile file = files[i];
			String fileType = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
			fileAttach.setFileType(fileType);
			String Ext = fileType;
			fileAttach.setExt(Ext);
			String fileName = System.currentTimeMillis()+fileType;
			fileAttach.setFileName(fileName);
			String realServerPath = "/Demo/public/upload/" + fileName;
			String filePath = realServerPath;
			fileAttach.setFilePath(filePath);
			fileAttach.setNote("activity pic");
			
			String absLocalPath = "D:/common/Documents/Github Repo/Jocoboy/MavenSpringProject/Doc-Eclipse/Demo/src/main/webapp/public/upload/"+ fileName;
			File destFile = new File(absLocalPath);
			FileUtils.copyInputStreamToFile(file.getInputStream(), destFile);
			
			fileAttachService.save(fileAttach);
			
			if(i == 0){
				activity.setFileAttach(fileAttach);
			}
			
			MultiActivityFileAttachEntity multiActivityFileAttach = new MultiActivityFileAttachEntity();
			multiActivityFileAttach.setFileAttach(fileAttach);
			multiFileAttachList.add(multiActivityFileAttach);
		}
		activity.setTitle(activityName);
		activity.setLocation(activityLocation);
		activity.setDetailLocation(activityLocationDetail);
//		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//		activity.setStartDate(LocalDateTime.parse(startDate.replace('T', ' '),dateTimeFormatter));
//		activity.setEndDate(LocalDateTime.parse(endDate.replace('T', ' '),dateTimeFormatter));
		activity.setStartDate(startDate.replace('T', ' '));
		activity.setEndDate(endDate.replace('T', ' '));
		activity.setDescription(activityDescription);
		
//		activity.setPostNum(activityPostnum);
//		activity.setFileAttachList(fileAttachList);
		activity.setMultiFileAttachList(multiFileAttachList);
		activity.setUser(userService.getCurrUser());
		
		foodActivityService.save(activity);
		
		return "redirect:/activity";
	}
}

package edu.zstu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import edu.zstu.dao.ActivityReserveDao;
import edu.zstu.entity.ActivityReserveEntity;
import edu.zstu.entity.FoodActivityEntity;
import edu.zstu.entity.UserEntity;

@Component	
@Transactional
public class ActivityReserveService extends CrudService<ActivityReserveEntity, ActivityReserveDao> {

	@Autowired
	private ActivityReserveDao activityReserveDao;
	
	@Override
	protected ActivityReserveDao getDao() {
		// TODO Auto-generated method stub
		return this.activityReserveDao;
	}

	
	public List<ActivityReserveEntity> findByUserAndActivity(UserEntity User,FoodActivityEntity Activity){
		return this.getDao().findByUserAndActivity(User, Activity);
	}
	
	public List<ActivityReserveEntity> findByUser(UserEntity User){
		return this.getDao().findByUser(User);
	}
}

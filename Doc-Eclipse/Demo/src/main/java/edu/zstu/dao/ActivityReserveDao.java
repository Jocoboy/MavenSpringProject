package edu.zstu.dao;

import java.util.List;

import edu.zstu.entity.ActivityReserveEntity;
import edu.zstu.entity.FoodActivityEntity;
import edu.zstu.entity.UserEntity;

public interface ActivityReserveDao extends BaseDao<ActivityReserveEntity> {
	List<ActivityReserveEntity> findByUserAndActivity(UserEntity User,FoodActivityEntity Activity);
	
	List<ActivityReserveEntity> findByUser(UserEntity User);
}

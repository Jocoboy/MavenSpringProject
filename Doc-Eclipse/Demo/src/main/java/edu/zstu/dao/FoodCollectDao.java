package edu.zstu.dao;

import java.util.List;

import edu.zstu.entity.FoodCollectEntity;
import edu.zstu.entity.FoodEntity;
import edu.zstu.entity.UserEntity;

public interface FoodCollectDao extends BaseDao<FoodCollectEntity> {
	List<FoodCollectEntity> findByUserAndFood(UserEntity User,FoodEntity Food);
}

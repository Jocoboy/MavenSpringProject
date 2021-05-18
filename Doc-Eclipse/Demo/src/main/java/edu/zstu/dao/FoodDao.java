package edu.zstu.dao;

import edu.zstu.entity.FoodEntity;

public interface FoodDao extends BaseDao<FoodEntity> {
	FoodEntity findByFoodName(String FoodName);
}

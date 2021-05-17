package edu.zstu.dao;

import edu.zstu.enity.FoodEnity;

public interface FoodDao extends BaseDao<FoodEnity> {
	FoodEnity findByFoodName(String FoodName);
}

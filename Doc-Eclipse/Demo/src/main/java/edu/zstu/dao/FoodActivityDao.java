package edu.zstu.dao;

import edu.zstu.entity.FoodActivityEntity;

public interface FoodActivityDao extends BaseDao<FoodActivityEntity> {
	FoodActivityEntity findByTitle(String Title);
}

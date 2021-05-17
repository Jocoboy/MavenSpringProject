package edu.zstu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import edu.zstu.dao.FoodDao;
import edu.zstu.enity.FoodEnity;

@Component	
@Transactional
public class FoodService extends CrudService<FoodEnity, FoodDao> {
	
	@Autowired
	private FoodDao foodDao;
	
	@Override
	protected FoodDao getDao() {
		// TODO Auto-generated method stub
		return this.foodDao;
	}

	public FoodEnity findByFoodName(String FoodName){
		return this.getDao().findByFoodName(FoodName);
	}
}

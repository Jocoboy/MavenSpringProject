package edu.zstu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import edu.zstu.dao.FoodActivityDao;
import edu.zstu.entity.FoodActivityEntity;

@Component	
@Transactional
public class FoodActivityService extends CrudService<FoodActivityEntity, FoodActivityDao> {

	@Autowired
	private FoodActivityDao foodActivityDao;
	
	@Override
	protected FoodActivityDao getDao() {
		// TODO Auto-generated method stub
		return this.foodActivityDao;
	}

	

	public FoodActivityEntity findByTitle(String Title){
		return this.getDao().findByTitle(Title);
	}
}

package edu.zstu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import edu.zstu.dao.FoodCollectDao;
import edu.zstu.entity.FoodCollectEntity;
import edu.zstu.entity.FoodEntity;
import edu.zstu.entity.UserEntity;

@Component	
@Transactional
public class FoodCollectService extends CrudService<FoodCollectEntity, FoodCollectDao> {
	@Autowired
	private FoodCollectDao foodCollectDao;
	
	@Override
	protected FoodCollectDao getDao() {
		// TODO Auto-generated method stub
		return this.foodCollectDao;
	}

	public List<FoodCollectEntity> findByUserAndFood(UserEntity User,FoodEntity Food){
		return this.getDao().findByUserAndFood(User,Food);
	}
	
	public List<FoodCollectEntity> findByUser(UserEntity User){
		return this.getDao().findByUser(User);
	}
}

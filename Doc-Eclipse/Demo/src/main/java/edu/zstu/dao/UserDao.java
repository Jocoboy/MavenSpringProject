package edu.zstu.dao;

import edu.zstu.entity.UserEntity;

public interface UserDao extends BaseDao<UserEntity> {
	UserEntity findByUsername(String Username);
}

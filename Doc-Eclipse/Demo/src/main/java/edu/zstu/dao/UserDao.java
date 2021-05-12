package edu.zstu.dao;

import edu.zstu.enity.UserEnity;

public interface UserDao extends BaseDao<UserEnity> {
	UserEnity findByUsername(String Username);
}

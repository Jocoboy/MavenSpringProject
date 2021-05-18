package edu.zstu.service;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.security.utils.Digests;
import org.springside.modules.utils.Encodes;

import edu.zstu.dao.UserDao;
import edu.zstu.entity.UserEntity;
import edu.zstu.service.ShiroDbRealm.ShiroUser;
 
@Component	
@Transactional
public class UserService extends CrudService<UserEntity, UserDao> {
	
	@Autowired
	private UserDao userdao;


	@Override
	protected UserDao getDao() {
		// TODO Auto-generated method stub
		return this.userdao;
	}

	public UserEntity findByUserName(String Username){
		
		return this.getDao().findByUsername(Username);
	}
	
	public void regUser(UserEntity user){
		String opassword = user.getPassword();
		byte[] salts = Digests.generateSalt(8); 
		String salt = Encodes.encodeHex(salts);
		user.setSalt(salt);
		byte[] hashPassword = Digests.sha1(opassword.getBytes(), salts, 1024); 
		String password = Encodes.encodeHex(hashPassword);
		user.setPassword(password);
		this.getDao().save(user);
	}
	
	public UserEntity getCurrUser(){
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		if(user!=null){
			return this.getDao().findOne(user.getId());
		}
		return null;
	}
}

package com.lhx.user;

import org.springframework.transaction.annotation.Transactional;

import com.lhx.utils.UUIDUtils;

@Transactional
public class UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	// 业务层注册用户代码
	public void regist(User user) {
		//保存用户
		user.setState(0); //0未激活，1已激活
		String code = UUIDUtils.getUUID();//生成激活码
		user.setCode(code);
		userDao.save(user);
		//发送邮件
	}
	
	
}

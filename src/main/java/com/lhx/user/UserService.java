package com.lhx.user;

import org.springframework.transaction.annotation.Transactional;

import com.lhx.utils.UUIDUtils;

@Transactional
public class UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	// ҵ���ע���û�����
	public void regist(User user) {
		//�����û�
		user.setState(0); //0δ���1�Ѽ���
		String code = UUIDUtils.getUUID();//���ɼ�����
		user.setCode(code);
		userDao.save(user);
		//�����ʼ�
	}
	
	
}

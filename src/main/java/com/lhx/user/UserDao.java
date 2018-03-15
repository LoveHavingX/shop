package com.lhx.user;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class UserDao extends HibernateDaoSupport{

	public void save(User user) {
		try {
			// dao�㱣���û��Ĵ���
			this.getHibernateTemplate().save(user);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	//Dao����ݼ������ѯ�û�
	public User findByCode(String code) {
		List<?> list = this.getHibernateTemplate().find("from User where code =?", code);
		if(list.size()!=0){
			return (User) list.get(0);
		}
		return null;
	}
	//dao���޸��û��ķ���
	public void updata(User existUser) {
		this.getHibernateTemplate().update(existUser);
	}
}

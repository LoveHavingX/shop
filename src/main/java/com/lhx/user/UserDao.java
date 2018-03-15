package com.lhx.user;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class UserDao extends HibernateDaoSupport{

	public void save(User user) {
		try {
			// dao层保存用户的代码
			this.getHibernateTemplate().save(user);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	//Dao层根据激活码查询用户
	public User findByCode(String code) {
		List<?> list = this.getHibernateTemplate().find("from User where code =?", code);
		if(list.size()!=0){
			return (User) list.get(0);
		}
		return null;
	}
	//dao层修改用户的方法
	public void updata(User existUser) {
		this.getHibernateTemplate().update(existUser);
	}
}

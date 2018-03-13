package com.lhx.user;

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
}

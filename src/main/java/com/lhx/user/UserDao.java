package com.lhx.user;

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
}

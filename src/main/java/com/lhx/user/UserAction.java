package com.lhx.user;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * �û���action
 * @author Administrator
 *
 */

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private User user = new User();
	
	public User getModel() {
		return user;
	}
	
	//��ת��ע��ҳ��ķ���
	public String registPage() {
		return "registPageSuccess";
	}
}

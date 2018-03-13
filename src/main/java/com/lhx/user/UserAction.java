package com.lhx.user;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 用户的action
 * @author Administrator
 *
 */

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private User user = new User();
	
	public User getModel() {
		return user;
	}
	
	//跳转到注册页面的方法
	public String registPage() {
		return "registPageSuccess";
	}
}

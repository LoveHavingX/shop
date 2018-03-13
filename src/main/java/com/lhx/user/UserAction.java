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
	
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getModel() {
		return user;
	}
	
	//跳转到注册页面的方法
	public String registPage() {
		return "registPageSuccess";
	}
	
	//用户注册
	public String regist() {
		userService.regist(user);
		return "registSuccess";
	}
}

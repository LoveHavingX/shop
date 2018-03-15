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
	
	public String active() {
		//根据激活码查询用户
		User existUser = userService.findByCode(user.getCode());
		if(existUser != null) {
			//修改用户状态
			existUser.setState(1);
			userService.update(existUser);
			//添加信息
			this.addActionMessage("激活成功，请去登陆");
		}else {
			this.addActionMessage("激活失败，激活码有误");
		}
		return "activeSuccess";
	}
	
	public String loginPage() {
		return "loginPageSuccess";
	}
}

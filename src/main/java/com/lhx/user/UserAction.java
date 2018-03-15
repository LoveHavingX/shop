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
	
	//��ת��ע��ҳ��ķ���
	public String registPage() {
		return "registPageSuccess";
	}
	
	//�û�ע��
	public String regist() {
		userService.regist(user);
		return "registSuccess";
	}
	
	public String active() {
		//���ݼ������ѯ�û�
		User existUser = userService.findByCode(user.getCode());
		if(existUser != null) {
			//�޸��û�״̬
			existUser.setState(1);
			userService.update(existUser);
			//�����Ϣ
			this.addActionMessage("����ɹ�����ȥ��½");
		}else {
			this.addActionMessage("����ʧ�ܣ�����������");
		}
		return "activeSuccess";
	}
	
	public String loginPage() {
		return "loginPageSuccess";
	}
}

package com.lhx.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

/**
 * �����ʼ��Ĺ�����
 * @author Administrator
 *
 */
public class MailUtils {
	public static void sendMail(String to, String code) throws Exception{
		Properties props = new Properties();
		props.setProperty("mail.smtp", "localhost");
		//1.Session����.���ӣ����ʼ����������ӣ�
		Session session = Session.getInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("service@shop.com", "123");
			}
		});
		//�����ʼ���Ϣ
		Message message = new MimeMessage(session);
		//�����ˣ�
		message.setFrom(new InternetAddress("service@shop.com"));
		//�ռ��ˣ�
		message.setRecipient(RecipientType.TO, new InternetAddress(to));
		//��������
		message.setContent("<h1>��������SHOP���������ʼ�</h1><h3><a href="
				+ "'http://192.168.0.110:8080/shop/user_active.action?code="+code+"'>"
				+ "http://192.168.0.110:8080/shop/user_active.action</a></h3>", "text/html;charset=UTF-8");
		//�����ʼ�
		Transport.send(message);
		
	}
}

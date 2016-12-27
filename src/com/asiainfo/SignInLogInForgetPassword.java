package com.asiainfo;

import org.apache.catalina.deploy.LoginConfig;
import org.apache.commons.lang.StringUtils;

import redis.clients.jedis.Jedis;

/**
 * Copyright: Copyright (c) 2016 Asiainfo
 * 
 * @ClassName: Login.java
 * @Description: ģ���û�ע�ᡢ��½���������루������Redis����ָ�ϡ�p107��
 * 
 * @version: v1.0.0
 * @author: zhangzw8
 * @date: 2016��12��27�� ����2:17:58
 * 
 *        Modification History: Date Author Version Description ---------------------------------------------------------* 2016��12��27�� zhangzw8 v1.0.0 ����
 */
public class SignInLogInForgetPassword {
	public static void main(String[] args) {
//		System.out.println(signIn("liming8909", "1234", "934109401@sina.com"));
//		System.out.println(logIn("934109401@qq.com", "1234"));
		System.out.println(changePassword("934109401@qq.com", "4321"));
		System.out.println(logIn("934109401@qq.com", "4321"));
	}

	public static String signIn(String nickName, String password, String email) {
		// ����ֻ����У��
		if (StringUtils.isBlank(nickName)) {
			return "�ǳƲ���Ϊ�գ�";
		}
		if (StringUtils.isBlank(password)) {
			return "���벻��Ϊ�գ�";
		}
		if (StringUtils.isBlank(email)) {
			return "���䲻��Ϊ�գ�";
		}

		Jedis jedis = new Jedis();
		if (jedis.hexists("email.to.id", email)) {
			return "�����ѱ�ע�ᣡ";
		}
		Long userId = jedis.incr("user.count");// ���û�������Ϊ�û�id
		jedis.hset("user:" + userId, "nickName", nickName);
		jedis.hset("user:" + userId, "password", password);
		jedis.hset("user:" + userId, "email", email);

		jedis.hset("email.to.id", email, userId.toString());

		return "ע��ɹ���";
	}

	public static String logIn(String email, String password) {
		if (StringUtils.isBlank(email) || StringUtils.isBlank(password)) {
			return "�û��������벻��Ϊ�գ�";
		}
		Jedis jedis = new Jedis();
		String userId = jedis.hget("email.to.id", email);
		if (StringUtils.isBlank(userId)) {
			return "�˵�½�û������ڣ�";
		}
		String pw = jedis.hget("user:" + userId, "password");
		if (!password.equals(pw)) {
			return "�������";
		}
		return "��½�ɹ���";
	}
	
	public static String changePassword(String email, String newPw) {
		//��У��
		Jedis jedis = new Jedis();
		String userId = jedis.hget("email.to.id", email);
		if(StringUtils.isBlank(userId)) {
			return "���û������ڣ�";
		}
		jedis.hset("user:" + userId, "password", newPw);
		return "�޸ĳɹ���";
	}
}

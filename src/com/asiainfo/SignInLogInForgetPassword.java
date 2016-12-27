package com.asiainfo;

import org.apache.catalina.deploy.LoginConfig;
import org.apache.commons.lang.StringUtils;

import redis.clients.jedis.Jedis;

/**
 * Copyright: Copyright (c) 2016 Asiainfo
 * 
 * @ClassName: Login.java
 * @Description: 模拟用户注册、登陆、忘记密码（參考《Redis入门指南》p107）
 * 
 * @version: v1.0.0
 * @author: zhangzw8
 * @date: 2016年12月27日 下午2:17:58
 * 
 *        Modification History: Date Author Version Description ---------------------------------------------------------* 2016年12月27日 zhangzw8 v1.0.0 创建
 */
public class SignInLogInForgetPassword {
	public static void main(String[] args) {
//		System.out.println(signIn("liming8909", "1234", "934109401@sina.com"));
//		System.out.println(logIn("934109401@qq.com", "1234"));
		System.out.println(changePassword("934109401@qq.com", "4321"));
		System.out.println(logIn("934109401@qq.com", "4321"));
	}

	public static String signIn(String nickName, String password, String email) {
		// 这里只做简单校验
		if (StringUtils.isBlank(nickName)) {
			return "昵称不能为空！";
		}
		if (StringUtils.isBlank(password)) {
			return "密码不能为空！";
		}
		if (StringUtils.isBlank(email)) {
			return "邮箱不能为空！";
		}

		Jedis jedis = new Jedis();
		if (jedis.hexists("email.to.id", email)) {
			return "邮箱已被注册！";
		}
		Long userId = jedis.incr("user.count");// 用用户数量作为用户id
		jedis.hset("user:" + userId, "nickName", nickName);
		jedis.hset("user:" + userId, "password", password);
		jedis.hset("user:" + userId, "email", email);

		jedis.hset("email.to.id", email, userId.toString());

		return "注册成功！";
	}

	public static String logIn(String email, String password) {
		if (StringUtils.isBlank(email) || StringUtils.isBlank(password)) {
			return "用户名或密码不能为空！";
		}
		Jedis jedis = new Jedis();
		String userId = jedis.hget("email.to.id", email);
		if (StringUtils.isBlank(userId)) {
			return "此登陆用户不存在！";
		}
		String pw = jedis.hget("user:" + userId, "password");
		if (!password.equals(pw)) {
			return "密码错误！";
		}
		return "登陆成功！";
	}
	
	public static String changePassword(String email, String newPw) {
		//简单校验
		Jedis jedis = new Jedis();
		String userId = jedis.hget("email.to.id", email);
		if(StringUtils.isBlank(userId)) {
			return "此用户不存在！";
		}
		jedis.hset("user:" + userId, "password", newPw);
		return "修改成功！";
	}
}

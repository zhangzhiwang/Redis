package com.asiainfo;

import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

/**   
 * Copyright: Copyright (c) 2016 Asiainfo
 * 
 * @ClassName: TestRedis.java
 * @Description: Java连接Redis测试
 *
 * @version: v1.0.0
 * @author: zhangzw8
 * @date: 2016年11月1日 下午5:45:08
 *
 * Modification History:
 * Date             Author          Version            Description
 *---------------------------------------------------------*
 * 2016年11月1日     zhangzw8           v1.0.0               创建
*/
public class TestRedis {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("localhost");
		System.out.println(jedis.ping());
		jedis.set("name", "aaa");
		System.out.println(jedis.get("name"));
		jedis.lpush("name2", "1", "2", "3");
		List<String> list = jedis.lrange("name2", 0, -1);
		if(list != null) {
			for(String str : list) {
				System.out.println(str);
			}
		}
		System.out.println("--------------");
		Set<String> set = jedis.keys("*");
		if(set != null) {
			for(String str : set) {
				System.out.println(str);
			}
		}
	}
}

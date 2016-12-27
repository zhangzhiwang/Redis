package com.asiainfo;

import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.SortingParams;

/**   
 * Copyright: Copyright (c) 2016 Asiainfo
 * 
 * @ClassName: TestRedis.java
 * @Description: Java����Redis����
 *
 * @version: v1.0.0
 * @author: zhangzw8
 * @date: 2016��11��1�� ����5:45:08
 *
 * Modification History:
 * Date             Author          Version            Description
 *---------------------------------------------------------*
 * 2016��11��1��     zhangzw8           v1.0.0               ����
*/
public class TestRedis {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("localhost");
		System.out.println(jedis.ping());
//		jedis.set("name", "aaa");
//		System.out.println(jedis.get("name"));
//		jedis.lpush("name2", "1", "2", "3");
//		List<String> list = jedis.lrange("name2", 0, -1);
//		if(list != null) {
//			for(String str : list) {
//				System.out.println(str);
//			}
//		}
//		System.out.println("--------------");
//		Set<String> set = jedis.keys("*");
//		if(set != null) {
//			for(String str : set) {
//				System.out.println(str);
//			}
//		}
		
		//����sort����
//		jedis.lpush("name9", "a","c","b","d");
		System.out.println(jedis.lrange("name9", 0, -1));
		
		SortingParams sortingParameters = new SortingParams();
		sortingParameters.alpha();
		sortingParameters.desc();
		System.out.println(jedis.sort("name9", sortingParameters));
		
		sortingParameters = new SortingParams();
		sortingParameters.by("post:*->time");
		sortingParameters.get("post:*->time", "post:*->title", "#");
		System.out.println(jedis.sort("tag:posts", sortingParameters));
	}
}

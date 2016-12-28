package com.asiainfo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;

/**
 * Copyright: Copyright (c) 2016 Asiainfo
 * 
 * @ClassName: AutoFill.java
 * @Description: 模拟自动补全，见课本p112
 * 
 * @version: v1.0.0
 * @author: zhangzw8
 * @date: 2016年12月28日 下午3:00:55
 * 
 *        Modification History: Date Author Version Description ---------------------------------------------------------* 2016年12月28日 zhangzw8 v1.0.0 创建
 */
public class AutoFill {
	public static void main(String[] args) {
		// System.out.println(autoFill("redh"));
		System.out.println(autoComplete("red"));
	}

	public static Set<String> autoFill(String input) {
		Jedis jedis = new Jedis();
		jedis.sadd("prefix:r", "redis", "ruby", "redhat");
		jedis.sadd("prefix:re", "redis", "redhat");
		jedis.sadd("prefix:red", "redis", "redhat");
		jedis.sadd("prefix:redi", "redis");
		jedis.sadd("prefix:ru", "ruby");
		jedis.sadd("prefix:rub", "ruby");
		jedis.sadd("prefix:redh", "redhat");
		jedis.sadd("prefix:redha", "redhat");
		return jedis.smembers("prefix:" + input);
	}

	public static Set<String> autoComplete(String input) {
		Jedis jedis = new Jedis();

		Map<String, Double> scoreMembers = new HashMap<String, Double>();
		scoreMembers.put("r", 0.0);
		scoreMembers.put("re", 0.0);
		scoreMembers.put("red", 0.0);
		scoreMembers.put("redi", 0.0);
		scoreMembers.put("redis*", 0.0);
		scoreMembers.put("ru", 0.0);
		scoreMembers.put("rub", 0.0);
		scoreMembers.put("ruby*", 0.0);
		scoreMembers.put("redh", 0.0);
		scoreMembers.put("redha", 0.0);
		scoreMembers.put("redhat*", 0.0);
		jedis.zadd("autoComplete", scoreMembers);
		Long index = jedis.zrank("autoComplete", input);
		Set<String> set = jedis.zrange("autoComplete", index + 1, scoreMembers.size());
		Set<String> setReturn = new HashSet<String>();
		if (set != null) {
			for (String word : set) {
				if (word.contains("*") && word.startsWith(input)) {
					setReturn.add(word.substring(0, word.length() - 1));
				}
			}
		}
		return setReturn;
	}
}

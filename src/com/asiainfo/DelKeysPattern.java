package com.asiainfo;

import java.util.Set;

import redis.clients.jedis.Jedis;

/**   
 * Copyright: Copyright (c) 2016 Asiainfo
 * 
 * @ClassName: DelKeysPattern.java
 * @Description: ����ģʽ�����h��
 *
 * @version: v1.0.0
 * @author: zhangzw8
 * @date: 2016��12��28�� ����3:26:52
 *
 * Modification History:
 * Date             Author          Version            Description
 *---------------------------------------------------------*
 * 2016��12��28��     zhangzw8           v1.0.0               ����
*/
public class DelKeysPattern {
	public static void main(String[] args) {
		System.out.println(batchDelPattern("autoComplete"));
	}
	
	public static String batchDelPattern(String pattern) {
		Jedis jedis = new Jedis();
		Set<String> keys = jedis.keys(pattern);
		if(keys != null) {
			for (String key : keys) {
				jedis.del(key);
			}
		}
		return "ok";
	}
}

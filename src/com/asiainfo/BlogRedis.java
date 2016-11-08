package com.asiainfo;

import java.util.Arrays;

import net.sf.json.JSONArray;
import redis.clients.jedis.Jedis;

/**   
 * Copyright: Copyright (c) 2016 Asiainfo
 * 
 * @ClassName: BlogRedis.java
 * @Description: ͨ��redisʵ�ּ��׵Ĳ���
 *
 * @version: v1.0.0
 * @author: zhangzw8
 * @date: 2016��11��4�� ����2:32:26
 *
 * Modification History:
 * Date             Author          Version            Description
 *---------------------------------------------------------*
 * 2016��11��4��     zhangzw8           v1.0.0               ����
*/
public class BlogRedis {
	public static void main(String[] args) {
		BlogRedis br = new BlogRedis();
		br.addBlog("����", "����", "����", "20161104");
	}
	public void addBlog(String title, String content, String author, String createTime) {
		Jedis jedis = new Jedis("localhost");
		jedis.flushDB();
		Long postsCount = jedis.incr("posts:count");//��������������������
		jedis.set("posts:" + postsCount + ":data", JSONArray.fromObject(Arrays.asList(title, content, author, createTime)).toString());
		System.out.println(jedis.get("posts:" + postsCount + ":data"));
		System.out.println(jedis.get("posts:count"));
	}
}

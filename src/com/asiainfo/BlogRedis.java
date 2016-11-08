package com.asiainfo;

import java.util.Arrays;

import net.sf.json.JSONArray;
import redis.clients.jedis.Jedis;

/**   
 * Copyright: Copyright (c) 2016 Asiainfo
 * 
 * @ClassName: BlogRedis.java
 * @Description: 通过redis实现简易的博客
 *
 * @version: v1.0.0
 * @author: zhangzw8
 * @date: 2016年11月4日 下午2:32:26
 *
 * Modification History:
 * Date             Author          Version            Description
 *---------------------------------------------------------*
 * 2016年11月4日     zhangzw8           v1.0.0               创建
*/
public class BlogRedis {
	public static void main(String[] args) {
		BlogRedis br = new BlogRedis();
		br.addBlog("标题", "内容", "作者", "20161104");
	}
	public void addBlog(String title, String content, String author, String createTime) {
		Jedis jedis = new Jedis("localhost");
		jedis.flushDB();
		Long postsCount = jedis.incr("posts:count");//文章主键（文章数量）
		jedis.set("posts:" + postsCount + ":data", JSONArray.fromObject(Arrays.asList(title, content, author, createTime)).toString());
		System.out.println(jedis.get("posts:" + postsCount + ":data"));
		System.out.println(jedis.get("posts:count"));
	}
}

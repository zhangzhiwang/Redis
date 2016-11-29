package com.asiainfo;

import net.sf.json.JSONObject;
import redis.clients.jedis.Jedis;

import com.asiainfo.entity.Comment;

/**
 * 用列表来存储评论
 *
 * @author zhiwangzhang
 * @date 2016年11月5日 下午2:18:39
 */
public class CommentList {
	public static void main(String[] args) {
		Comment comment1 = new Comment("a1", "20161105", "c1", "e1");
		Comment comment2 = new Comment("a2", "20161106", "c2", "e2");
		Comment comment3 = new Comment("a3", "20161107", "c3", "e3");
		Jedis jedis = new Jedis();
		jedis.del("post:1:comments");
		// 文章id为1的评论
		jedis.lpush("post:1:comments", JSONObject.fromObject(comment1).toString(), JSONObject.fromObject(comment2).toString(), JSONObject.fromObject(comment3).toString());
		System.out.println(jedis.lrange("post:1:comments", 0, -1));
	}
}

package com.asiainfo;

import redis.clients.jedis.Jedis;

import com.asiainfo.entity.Article;

/**
 * 可用集合来保存文章标签
 *
 * @author zhiwangzhang
 * @date 2016年11月5日 下午4:07:05
 */
public class SetForTags {
	public static void main(String[] args) {
		Article article1 = new Article("1", "t1", "a1", "c1", "20161105", "s1" ,"tag1");
		Article article2 = new Article("2", "t2", "a2", "c2", "20161106", "s2", "tag1,tag2");
		Article article3 = new Article("3", "t3", "a3", "c3", "20161107", "s3", "tag1, tag2, tag3");
		Jedis jedis = new Jedis("localhost");
		jedis.flushDB();
		jedis.sadd("post:1:tags", article1.getTags());
		jedis.sadd("post:2:tags", article2.getTags());
		jedis.sadd("post:3:tags", article3.getTags());
		System.out.println(jedis.smembers("post:1:tags"));
		System.out.println(jedis.smembers("post:2:tags"));
		System.out.println(jedis.smembers("post:3:tags"));
		//通过标签搜索文章
		jedis.sadd("tag:tag1:posts", "1", "2", "3");//具有标签tag1的文章有1、2、3，下同
		jedis.sadd("tag:tag2:posts", "2", "3");
		jedis.sadd("tag:tag3:posts", "3");
		System.out.println(jedis.sinter("tag:tag1:posts", "tag:tag2:posts", "tag:tag3:posts"));//找出同时具有tag1、tag2、tag3的文章id
		//找出了文章id就可以获取该文章的信息
		jedis.hgetAll("post:1");
	}
}

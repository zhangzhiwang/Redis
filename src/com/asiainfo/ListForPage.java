package com.asiainfo;

import java.util.List;

import com.asiainfo.entity.Article;

import redis.clients.jedis.Jedis;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 列表存储文章id，用于分页
 *
 * @author zhiwangzhang
 * @date 2016年11月5日 下午1:31:23
 */
public class ListForPage {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Article article1 = new Article("1", "t1", "a1", "c1", "20161105", "s1");
		Article article2 = new Article("2", "t2", "a2", "c2", "20161106", "s2");
		Article article3 = new Article("3", "t3", "a3", "c3", "20161107", "s3");
		JSONObject.fromObject(article1);
		Jedis jedis = new Jedis("localhost");
		jedis.del("post:1", "post:2", "post:3");
		jedis.hmset("post:1", JSONObject.fromObject(article1));
		jedis.hmset("post:2", JSONObject.fromObject(article2));
		jedis.hmset("post:3", JSONObject.fromObject(article3));
		jedis.lpush("posts:list", "1");
		jedis.lpush("posts:list", "2");
		jedis.lpush("posts:list", "3");
		System.out.println(jedis.hgetAll("post:1"));
		System.out.println(jedis.hgetAll("post:2"));
		System.out.println(jedis.hgetAll("post:3"));
		System.out.println(jedis.lrange("posts:list", 0, -1));
		ListForPage lfp = new ListForPage();
		List<String> idList = lfp.getIdList(2, 1, jedis);
		System.out.println(idList);
		for (String id : idList) {
			System.out.println(jedis.hget("post:" + id, "title"));
		}
	}
	
	public List<String> getIdList(int pageSize, int curPage, Jedis jedis) {
		int start = (curPage - 1) * pageSize;
		int end = curPage * pageSize - 1;
		return jedis.lrange("posts:list", start, end);
	}
}

import java.util.HashMap;
import java.util.Map;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisDataException;

/**
 * Copyright: Copyright (c) 2016 Asiainfo
 * 
 * @ClassName: TestJRedis.java
 * @Description:测试Jedis
 * 
 * @version: v1.0.0
 * @author: zhangzw8
 * @date: 2016年12月12日 下午12:12:54
 * 
 *        Modification History: Date Author Version Description ---------------------------------------------------------* 2016年12月12日 zhangzw8 v1.0.0 创建
 */
public class TestJedis {
	public static void main(String[] args) {
		Jedis jedis = new Jedis();
		jedis.set("name", "aaa");
		System.out.println(jedis.get("name"));
		System.out.println(jedis.get("name1"));

		jedis.sadd("name2", "1,2");
		try {
			System.out.println(jedis.get("name2"));
		} catch (JedisDataException e) {
			System.out.println(e.getMessage());
		}
		
//		jedis.lpush("name3", "1,2,3");
//		System.out.println(jedis.lrange("name3", 0, -1));
		
		jedis.mset("name4", "1", "name5", "2", "name6", "3");
		System.out.println(jedis.mget("name4", "name5", "name6"));
		
		Map<String, String> map = new HashMap<String, String>(); 
		map.put("f1", "aaa");
		map.put("f2", "bbb");
		map.put("f3", "ccc");
		jedis.hmset("name7", map);
		System.out.println(jedis.hmget("name7", "f1", "f3"));
		System.out.println(jedis.hgetAll("name7"));
		
		jedis.sadd("name8", "a", "b", "c");
		System.out.println(jedis.smembers("name8"));
		
		Map<String, Double> map2 = new HashMap<String, Double>();
		map2.put("aa", 10.5);
		map2.put("bb", 0.5);
		map2.put("cc", (double)20);
		jedis.zadd("name9", map2);
		System.out.println(jedis.zrange("name9", 0, -1));
		System.out.println(jedis.zrangeWithScores("name9", 0, -1));
		
	}
}

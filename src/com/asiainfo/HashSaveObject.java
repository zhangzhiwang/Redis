package com.asiainfo;

import java.util.HashMap;
import java.util.Map;

import redis.clients.jedis.Jedis;

/**
 * Copyright: Copyright (c) 2016 Asiainfo
 * 
 * @ClassName: HashSaveObject.java
 * @Description: 散列一般用于存储对象
 * 
 * @version: v1.0.0
 * @author: zhangzw8
 * @date: 2016年11月4日 下午5:26:23
 * 
 *        Modification History: Date Author Version Description ---------------------------------------------------------* 2016年11月4日 zhangzw8 v1.0.0 创建
 */
public class HashSaveObject {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("localhost");
		jedis.flushDB();
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("name", "name1");
		map1.put("price", "10");
		map1.put("color", "black");
		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("name", "name2");
		map2.put("price", "20");
		map2.put("color", "yellow");
		jedis.hmset("car:1", map1);
		jedis.hmset("car:2", map2);
		System.out.println(jedis.hgetAll("car:1"));
		System.out.println(jedis.hgetAll("car:2"));
	}
}

class Car {
	private int id;
	private String name;
	private double price;
	private String color;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Car(int id, String name, double price, String color) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.color = color;
	}

	public Car() {
		super();
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", price=" + price + ", color=" + color + "]";
	}

}

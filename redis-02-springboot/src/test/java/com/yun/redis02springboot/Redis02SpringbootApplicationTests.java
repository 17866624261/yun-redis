package com.yun.redis02springboot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yun.redis02springboot.pojo.User;
import com.yun.redis02springboot.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class Redis02SpringbootApplicationTests {

	@Autowired
	@Qualifier("redisTemplate")
	private RedisTemplate redisTemplate;

	@Autowired
	private RedisUtil redisUtil;

	@Test
	void contextLoads() {
		// 在企业开发中，我们80%的情况下，都不会使用这个原生的方式去编写代码
		// 可以自己写一个redisUtils

		// 操作不同的数据类型，再用.进行操作
		// opsForValue 操作字符串	类似String
		// opsForList  操作List 类似List
		// opsForSet
		// opsForHash
		// opsForZSet
		// opsForGeo
		// opsForHyperLogLog

		// 除了基本的操作，常用的方法都可以通过redisTemplate操作，比如事务和基本CRUD
		redisTemplate.opsForHyperLogLog();

		// 获取redis的连接对象
		RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
		connection.flushDb();


	}

	@Test
	public void test() throws JsonProcessingException {
		// 真实的开发，一般使用json来传递对象
		User user = new User("Yun", 3);
		String jsonUser = new ObjectMapper().writeValueAsString(user);
		redisTemplate.opsForValue().set("user",user);
		System.out.println(redisTemplate.opsForValue().get("user"));
	}

	@Test
	public void test1(){
		redisUtil.set("name","yun");
		System.out.println(redisUtil.get("name"));
	}
}

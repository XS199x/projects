package com.mock.util.cache;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * Title: CacheKeyGenerator
 * Description: TODO
 *
 * @author xuf
 * @version V1.0
 * @date 2019-11-15
 */
@Component
public class CacheKeyGenerator implements KeyGenerator {
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Override
	public Object generate(Object target, Method method, Object... params){
		Map<String, Object> map = new HashMap<>(2);
		//放入target的名字
		map.put("target", target.getClass().toGenericString());
		//放入method的名字
		map.put("method", method.getName());
		//把所有参数放进去
		if (params != null && params.length > 0) {
			int i = 0;
			for (Object o : params) {
				map.put("params-" + i, o);
				i++;
			}
		}
		
		byte[] hash = null;
		try {
			String str = objectMapper.writeValueAsString(map);
			hash = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		//使用MD5生成位移key
		return MD5Encoder.encode(hash);
	}

}

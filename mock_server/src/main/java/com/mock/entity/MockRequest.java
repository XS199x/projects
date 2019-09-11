package com.mock.entity;

import lombok.Data;

import java.util.Map;

/**
 * @author
 * 请求相关
 */
@Data
public class MockRequest {
	
	private String method;
	
	private String url;
	
	private Map<String,String> headers;
	
	private Map<String,Object> params;
	
	private String content;
}

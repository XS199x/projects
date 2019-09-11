package com.mock.entity;

import lombok.Data;

/**
 * @author
 * mock请求详情
 */
@Data
public class MockDetail {
	
	private MockRequest mockRequest;
	
	private String js;
	
	private MockResponse mockResponse;
	
	private int delay;
	
	private String callbackUrl;
	
	private String description;
	
}

package com.mock.entity;

import lombok.Data;

import java.util.Map;

/**
 * @author
 */
@Data
public class MockResponse {
	
	private Map<String,String> headers;
	
	private Object content;
}

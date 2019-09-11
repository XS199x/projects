package com.mock.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mock.controller.MockController;
import com.mock.entity.MockDetail;
import com.mock.entity.MockInterfaceData;
import com.mock.entity.MockRequest;
import com.mock.service.IMockInterfaceService;
import com.mock.service.IMockRequestService;
import com.mock.util.http.HttpApiService;
import com.mock.util.http.HttpResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author
 * Mock请求处理
 */
@Service
public class MockRequestImpl implements IMockRequestService {
	
	private static Logger log = LoggerFactory.getLogger(MockController.class);
	
	private static String GET = "get";
	
	private static String POST = "post";
	
	@Autowired
	private ObjectMapper mapper;
	
	@Autowired
	private IMockInterfaceService iMockInterfaceService;
	
	@Autowired
	private ThreadPoolTaskScheduler scheduler;
	
	@Autowired
	private HttpApiService httpApiService;
	
	@Bean
	public ScheduledExecutorService scheduledExecutorService() {
		return scheduler.getScheduledExecutor();
	}
	
	@Override
	public void mockCallback(MockDetail mockDetail) throws Exception{
		
		String callbackUrl = mockDetail.getCallbackUrl();
		MockInterfaceData mockInterfaceData = iMockInterfaceService.getMockRequestByRouteUrl(callbackUrl);
		String requestDetail = mockInterfaceData.getRequestDetail();
		
		MockDetail callbackMockDetail = mapper.readValue(requestDetail, MockDetail.class);
		
		int delay = callbackMockDetail.getDelay();
		MockRequest callbackMockRequest = callbackMockDetail.getMockRequest();
		String url = callbackMockRequest.getUrl();
		String method = callbackMockRequest.getMethod();
		Map<String,Object> params = callbackMockRequest.getParams();
		Map<String,String> headers = callbackMockRequest.getHeaders();
		
		scheduler.getScheduledExecutor().schedule(()->{
			try{
				if(method.toLowerCase().equals(GET)){
					String res = httpApiService.doGet(url,params,headers);
					log.info(res);
				}else{
					HttpResult httpResult = httpApiService.doPost(url,params,headers);
					log.info(mapper.writeValueAsString(httpResult));
				}
			}catch (Exception e){
				log.error(e.getMessage());
			}
		},delay, TimeUnit.SECONDS);
	}
}

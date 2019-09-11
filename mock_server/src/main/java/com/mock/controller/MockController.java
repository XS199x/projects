package com.mock.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mock.entity.MockDetail;
import com.mock.entity.MockInterfaceData;
import com.mock.entity.MockResponse;
import com.mock.service.IMockInterfaceService;
import com.mock.service.IMockRequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

/**
 * @author
 */
@RestController
@RequestMapping(value = "/mock")
public class MockController {
	
	private static Logger log = LoggerFactory.getLogger(MockController.class);
	
	@Autowired
	private ObjectMapper mapper;
	
	@Autowired
	private IMockInterfaceService iMockInterfaceService;
	
	@Autowired
	private IMockRequestService iMockRequestService;
	
	@RequestMapping(value = "/**")
	@ResponseBody
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String routeUrl = request.getServletPath();
		MockInterfaceData mockInterfaceData= iMockInterfaceService.getMockRequestByRouteUrl(routeUrl);
		String requestDetail = mockInterfaceData.getRequestDetail();
		
		log.info(routeUrl);
		log.info(requestDetail);
		MockDetail mockDetail = mapper.readValue(requestDetail, MockDetail.class);
		
		MockResponse mockResponse = mockDetail.getMockResponse();
		mockResponse.getHeaders().forEach((k,v)-> response.setHeader(k,v));
		OutputStream out = response.getOutputStream();
		out.write(mapper.writeValueAsString(mockResponse.getContent()).getBytes("UTF-8"));
		out.flush();
		
		if(mockDetail.getCallbackUrl() != null){
			iMockRequestService.mockCallback(mockDetail);
		}
		log.info("success");
	}
}

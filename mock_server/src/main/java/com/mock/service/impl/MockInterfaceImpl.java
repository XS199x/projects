package com.mock.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mock.dao.MockRequestMapper;
import com.mock.entity.MockDetail;
import com.mock.entity.MockRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mock.entity.MockInterfaceData;
import com.mock.service.IMockInterfaceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author
 */
@Service
public class MockInterfaceImpl implements IMockInterfaceService, Serializable {

	@Autowired
	private MockRequestMapper mockRequestMapper;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Override
	public PageInfo<MockInterfaceData> getMockRequestList(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<MockInterfaceData> list = mockRequestMapper.getMockRequestList();
		PageInfo<MockInterfaceData> page = new PageInfo<>(list);
		return page;
	}
	
	@Override
	public MockInterfaceData getMockRequestByRouteUrl(String routeUrl) {
		List<MockInterfaceData> list = mockRequestMapper.getMockRequestByRouteUrl(routeUrl);
		return list.get(0);
	}
	
	@Override
	public void insertMockRequest(MockInterfaceData mockInterfaceData) {
		mockRequestMapper.insertMockRequest(mockInterfaceData);
	}
	
	@Override
	public void updateMockRequest(MockInterfaceData mockInterfaceData) {
		mockRequestMapper.updateMockRequest(mockInterfaceData);
	}
	
	@Override
	public void deleteMockRequest(int mockRequestId) {
		mockRequestMapper.deleteMockRequest(mockRequestId);
	}
	
	@Override
	public MockInterfaceData getMockRequestById(int mockRequestId) {
		return mockRequestMapper.getMockRequestById(mockRequestId);
	}
	
	
}
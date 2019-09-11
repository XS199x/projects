package com.mock.service;


import com.mock.entity.MockInterfaceData;
import com.github.pagehelper.PageInfo;

/**
 * @author
 */
public interface IMockInterfaceService {
	/**
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	PageInfo<MockInterfaceData> getMockRequestList(int pageNum, int pageSize);
	
	MockInterfaceData getMockRequestByRouteUrl(String routeUrl);
	
	void insertMockRequest(MockInterfaceData mockInterfaceData);
	
	void updateMockRequest(MockInterfaceData mockInterfaceData);
	
	void deleteMockRequest(int mockRequestId);
	
	MockInterfaceData getMockRequestById(int mockRequestId);
	
}

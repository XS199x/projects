package com.mock.dao;

import java.util.List;

import com.mock.entity.MockInterfaceData;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author
 */
@Mapper
public interface MockRequestMapper {
	/**
	 * 根据路由查找接口
	 * @return
	 */
	List<MockInterfaceData> getMockRequestByRouteUrl(String routeUrl);
	
	List<MockInterfaceData> getMockRequestList();
	
	void insertMockRequest(MockInterfaceData mockInterfaceData);
	
	void updateMockRequest(MockInterfaceData mockInterfaceData);
	
	void deleteMockRequest(int mockRequestId);
	
	MockInterfaceData getMockRequestById(int mockRequestId);
}

package com.mock.service;

import com.mock.entity.MockDetail;

/**
 * @author
 */
public interface IMockRequestService {
	/**
	 * 回调
	 * @param mockDetail
	 * @throws Exception
	 */
	void mockCallback(MockDetail mockDetail) throws Exception;
}

package com.mock.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author
 * mock_interface实体
 */
public class MockInterfaceData {
	@Getter
	@Setter
	private Integer id;
	@Getter
	@Setter
	private String name;
	@Getter
	@Setter
	private String description;
	@Getter
	@Setter
	private String routeUrl;
	@Getter
	@Setter
	private String requestDetail;
	@Getter
	@Setter
	private int enabledStatus;
}

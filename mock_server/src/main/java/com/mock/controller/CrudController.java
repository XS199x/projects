package com.mock.controller;

import com.github.pagehelper.PageInfo;
import com.mock.entity.MockInterfaceData;
import com.mock.service.IMockInterfaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/crud")
public class CrudController {
	
	private static Logger log = LoggerFactory.getLogger(CrudController.class);
	
	@Autowired
	private IMockInterfaceService iMockInterfaceService;
	
	@GetMapping(value = "/queryMockReq")
	public Map<String, Object> queryjob(@RequestParam(value = "pageNum") Integer pageNum, @RequestParam(value = "pageSize") Integer pageSize) {
		PageInfo<MockInterfaceData> mockList = iMockInterfaceService.getMockRequestList(pageNum, pageSize);
		Map<String, Object> map = new HashMap<String, Object>(32);
		map.put("mockList", mockList);
		map.put("number", mockList.getTotal());
		return map;
	}
	
	@PostMapping(value = "/saveMockReq")
	public void saveMockReq(@RequestParam(value = "id") Integer id,
	                        @RequestParam(value = "name") String name,
	                        @RequestParam(value = "description") String description,
	                        @RequestParam(value = "routeUrl") String routeUrl,
	                        @RequestParam(value = "requestDetail") String requestDetail) throws Exception {
		MockInterfaceData mockInterfaceData = new MockInterfaceData();
		mockInterfaceData.setName(name);
		mockInterfaceData.setDescription(description);
		mockInterfaceData.setRouteUrl(routeUrl);
		mockInterfaceData.setRequestDetail(requestDetail);
		
		Optional optional = Optional.ofNullable(id);
		if (optional.isPresent()) {
			mockInterfaceData.setId(id);
			iMockInterfaceService.updateMockRequest(mockInterfaceData);
		} else {
			iMockInterfaceService.insertMockRequest(mockInterfaceData);
		}
	}
	
	@PostMapping(value = "/deleteMockReq")
	public void deleteMockReq(@RequestParam(value = "id") int id) throws Exception {
		iMockInterfaceService.deleteMockRequest(id);
	}
	
}

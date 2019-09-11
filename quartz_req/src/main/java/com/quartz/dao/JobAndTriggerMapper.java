package com.quartz.dao;

import java.util.List;

import com.quartz.entity.JobAndTrigger;

/**
 * @author
 */
public interface JobAndTriggerMapper {
	/**
	 * mapper
	 * @return
	 */
	List<JobAndTrigger> getJobAndTriggerDetails();
}

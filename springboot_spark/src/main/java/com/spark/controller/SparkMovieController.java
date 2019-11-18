package com.spark.controller;

import com.spark.service.SparkMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Title: MovieController
 * Description: TODO
 *
 * @author xuf
 * @version V1.0
 * @date 2019-11-14
 */
@RestController
public class SparkMovieController {

	@Autowired
	private SparkMovieService sparkMovieService;
	
	@RequestMapping("/movie/top10")
	public Map<String,Object> calculateRatingTopTen(){
		return sparkMovieService.calculateRatingTopTen();
	}
}

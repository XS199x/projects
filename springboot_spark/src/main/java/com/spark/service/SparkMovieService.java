package com.spark.service;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scala.Tuple2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Title: SparkMovieService
 * Description: TODO
 *
 * @author xuf
 * @version V1.0
 * @date 2019-11-14
 */
@Service
public class SparkMovieService {
	
	private static final Logger LOG = LoggerFactory.getLogger(SparkDemoService.class);
	
	private static final Pattern SPACE = Pattern.compile(",");
	
	@Autowired
	private JavaSparkContext sc;
	
	public Map<String, Object> calculateRatingTopTen() {
		Map<String,Object> result = new HashMap<>(16);
		
		JavaRDD<String> lines = sc.textFile("C:/Users/xufan/Desktop/ml-latest/ratings.csv").cache();
		LOG.info(lines.first());
		JavaPairRDD<String,Long> movieIds = lines.mapToPair((line)->new Tuple2<>(SPACE.split(line)[1],1L));
		LOG.info(movieIds.first().toString());
		JavaPairRDD<String,Long> ratings = movieIds.reduceByKey((x,y)->x+y);
		
		JavaPairRDD<Long, String> temp = ratings.mapToPair(tuple -> new Tuple2<>(tuple._2, tuple._1));
		
		JavaPairRDD<String, Long> sorted = temp.sortByKey(false).mapToPair(tuple -> new Tuple2<>(tuple._2, tuple._1));
		LOG.info("电影数："+sorted.count());
		List<Tuple2<String, Long>> output = sorted.take(10);
		output.forEach((tuple)->{
			result.put(tuple._1(), tuple._2());
		});
		return result;
	}
}

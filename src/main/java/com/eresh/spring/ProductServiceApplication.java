package com.eresh.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

import io.micrometer.core.instrument.binder.hystrix.HystrixMetricsBinder;

@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrixDashboard
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
	
	
	@Bean
	HystrixMetricsBinder hystrixMetrics(){
	    return new HystrixMetricsBinder();
	}

}



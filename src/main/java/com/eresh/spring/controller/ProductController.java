package com.eresh.spring.controller;

import com.eresh.spring.util.BaseRestOutboundProcessor;
import com.eresh.spring.ws.WSDiscount;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	BaseRestOutboundProcessor baseRestOutboundProcessor;

	@GetMapping("/hi")
	public ResponseEntity<String> sayHi() {
		return ResponseEntity.ok("Hi");
	}

	@GetMapping("/discounts")
	@HystrixCommand(fallbackMethod = "getDefaultDiscount", commandKey = "getDefaultDiscountCommandKey", threadPoolKey = "getDefaultDiscountThreadPool")
	public Mono<WSDiscount> getProductDiscount(@RequestParam("id") String id) {
		System.out.println("Into Controller....");
		//ResponseEntity<WSDiscount> responseEntity = baseRestOutboundProcessor.get("http://product-discount.com?id=" + id, null, WSDiscount.class, new HashMap<>());
		if(true) {
			return Mono.error(new RuntimeException());
		}
		return Mono.empty();
		//return ResponseEntity.ok(responseEntity.getBody());
	}

	public Mono<WSDiscount> getDefaultDiscount(String id) {
		
		System.out.println("Into Fallback....");
		
		WSDiscount discount = new WSDiscount();
		discount.setMaxDiscount("0");
		discount.setProductId(id);
		return Mono.empty();
	}
}

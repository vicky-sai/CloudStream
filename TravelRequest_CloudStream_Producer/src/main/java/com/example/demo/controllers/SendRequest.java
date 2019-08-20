package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TravelRequest;

@RestController
@EnableBinding(Source.class)
public class SendRequest {
	
	@Autowired
	private Source source;
	
	@GetMapping("/makeRequest")
	public String dispatchRequest() {
		
		TravelRequest req = new TravelRequest(10, 20653,"Vikas","A2",23000.00,"Client Meeting");
		source.output().send(MessageBuilder.withPayload(req).build());
		return "One Request sent--";
	}
	
//	@PostMapping("/makeRequest")
//	public String dispatchRequest(@RequestBody TravelRequest request) {
//		
//		 source.output().send(MessageBuilder.withPayload(request).build());
//		return "One Request sent";
//	}
}

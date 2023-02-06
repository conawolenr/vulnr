package com.newrelic.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestParam;

import org.apache.log4j.BasicConfigurator;  
import org.apache.log4j.LogManager;  
import org.apache.log4j.Logger;  

@RestController
class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    private static final Logger logger = LogManager.getLogger(GreetingController.class);  

	GreetingController() {
	}

    @GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String content) {
        logger.info("Hello world");  
		return new Greeting(counter.incrementAndGet(), String.format(template, content));
	}

}

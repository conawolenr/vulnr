package com.newrelic.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// import org.apache.logging.log4j.Logger;
// import org.apache.logging.log4j.LogManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class GreetingController {

    //private static final Logger LOGGER = LogManager.getLogger();
    private static final Logger logger = LoggerFactory.getLogger(GreetingController.class);

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		logger.info("Hello, {}!", this);
        logger.debug("showVetList: This is a debug message");
		logger.info("showVetList: This is an info message");
		logger.warn("showVetList: This is a warn message");
		logger.error("showVetList: This is an error message");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}

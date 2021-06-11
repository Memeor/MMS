package com.memeor.mms;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/status/v1")
@Slf4j
public class HealthCheckController {

	@GetMapping
	public String getStatus() {
		log.info("Healthcheck API called");
		return "Application is up";
	}
}

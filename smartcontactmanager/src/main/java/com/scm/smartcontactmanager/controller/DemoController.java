package com.scm.smartcontactmanager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping("/v1/scm/test")
	public ResponseEntity<String> sayHello(@RequestHeader(name = "Authorization", required = false) String token) {
		return ResponseEntity.ok("Api Test Successful");
	}

}

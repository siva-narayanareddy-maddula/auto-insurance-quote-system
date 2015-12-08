package org.siva.narayan.aiqs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/simple")
public class SimpleController {
	
	@RequestMapping(value = "/message", method = RequestMethod.GET)
	public @ResponseBody String message() {
		return "Hello, World";
	}

}

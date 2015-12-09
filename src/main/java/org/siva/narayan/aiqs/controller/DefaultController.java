package org.siva.narayan.aiqs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DefaultController {

	@RequestMapping(method = RequestMethod.GET)
	public String defaultView() {
		return "welcome";
	}
}

package com.mkyong.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 @author bpm
 */
@Controller
@RequestMapping("/welcome")
public class HelloController {
/**
 @author bpm
 @return devuelve hello
*/
@RequestMapping(method = RequestMethod.GET)
public String printWelcome(final ModelMap model) {
	model.addAttribute("message",	"Spring Security Hello World");
	return "hello";
 }
}

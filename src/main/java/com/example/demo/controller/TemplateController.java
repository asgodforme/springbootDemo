package com.example.demo.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TemplateController {

	/**
	 * 
	 * 返回html模板.
	 */
	@RequestMapping("/helloHtml")
	public String helloHtml(Map<String, Object> map) {
		map.put("hello", "from TemplateController.helloHtml");
		map.put("hello1", "from jiangjie's TemplateController.helloHtml");
		
		return "/helloHtml";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "/index";
	}
}

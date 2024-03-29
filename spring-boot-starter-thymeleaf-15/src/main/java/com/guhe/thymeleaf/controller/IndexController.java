package com.guhe.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author njl
 * @date 2023/3/15
 */
@RequestMapping("/thymeleaf")
@Controller
public class IndexController {
	@GetMapping
	public String index(ModelMap modelMap) {
		modelMap.put("username", "stein");
		modelMap.put("password", "njl283036");
		return "index";
	}

	@GetMapping("/echarts")
	public String echarts() {
		return "echarts";
	}
}

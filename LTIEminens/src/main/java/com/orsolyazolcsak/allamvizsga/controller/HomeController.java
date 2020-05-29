package com.orsolyazolcsak.allamvizsga.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {
	@RequestMapping(value = "/")
	public String index() {
		return "index.html";
	}

}

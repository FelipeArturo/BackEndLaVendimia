package com.lavendimia.main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Home")
public class ControllerHome {

	@GetMapping("/Prueba")
	public String Home() {
		return "Hola War Desplegado Correctamente";
	}
}

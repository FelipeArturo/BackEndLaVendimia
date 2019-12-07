package com.lavendimia.main.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lavendimia.main.entity.Cliente;
import com.lavendimia.main.service.IClienteService;

@RestController
@RequestMapping("/api/Clientes")
public class ClienteRestController {
	
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/getAllClientes")
	@ResponseStatus(HttpStatus.OK)
	public List<Cliente> getProfesores(){
		return clienteService.findAll();
	}
	
	@PostMapping("/guardarCliente")
	public ResponseEntity<Void> addProfesor(@RequestBody Cliente cliente){
		if(clienteService.findCliente(cliente)==null) {
			clienteService.saveCliente(cliente);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}
}

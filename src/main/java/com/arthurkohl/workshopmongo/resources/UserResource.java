package com.arthurkohl.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arthurkohl.workshopmongo.domain.User;
import com.arthurkohl.workshopmongo.services.UserService;

@RestController //indica que a classe será um recurso rest
@RequestMapping(value = "/users") //qual o endereco para acessar esse recurso
public class UserResource {

	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}

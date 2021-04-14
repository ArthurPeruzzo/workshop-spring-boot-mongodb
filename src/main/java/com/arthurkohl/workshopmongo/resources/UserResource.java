package com.arthurkohl.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arthurkohl.workshopmongo.domain.User;
import com.arthurkohl.workshopmongo.dto.UserDTO;
import com.arthurkohl.workshopmongo.services.UserService;

@RestController //indica que a classe será um recurso rest
@RequestMapping(value = "/users") //qual o endereco para acessar esse recurso
public class UserResource {

	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}

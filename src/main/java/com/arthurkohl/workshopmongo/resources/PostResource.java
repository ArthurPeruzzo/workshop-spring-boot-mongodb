package com.arthurkohl.workshopmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arthurkohl.workshopmongo.domain.Post;
import com.arthurkohl.workshopmongo.services.PostService;


@RestController //indica que a classe será um recurso rest
@RequestMapping(value = "/posts") //qual o endereco para acessar esse recurso
public class PostResource {

	@Autowired
	private PostService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
		
		Post obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
}

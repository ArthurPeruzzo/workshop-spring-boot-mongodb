package com.arthurkohl.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.arthurkohl.workshopmongo.domain.Post;
import com.arthurkohl.workshopmongo.domain.User;
import com.arthurkohl.workshopmongo.dto.AuthorDTO;
import com.arthurkohl.workshopmongo.repository.PostRepository;
import com.arthurkohl.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		//salvando usuarios
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post pos1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post pos2 = new Post(null, sdf.parse("21/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
				
		//salvando posts
		postRepository.saveAll(Arrays.asList(pos1, pos2));
		
		//fazendo as associacoes entre post e usuario
		maria.getPosts().addAll(Arrays.asList(pos1, pos2));
		
		//salvando a associacao
		userRepository.save(maria);
		
	}

}

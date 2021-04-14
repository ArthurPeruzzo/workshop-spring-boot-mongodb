package com.arthurkohl.workshopmongo.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.arthurkohl.workshopmongo.services.exception.ObjectNotFoundException;

@ControllerAdvice //classe responsavel por tratar possiveis erros nas requisicoes
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class) // é necessario para quando acontecer a excecao, executar o tratamento
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError (System.currentTimeMillis(), status.value() , "Nao encontrado!", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
}

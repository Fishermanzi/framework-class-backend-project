package br.com.espm.felipethiago.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "AAAAA")
public class UsernameAlreadyExistsException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public UsernameAlreadyExistsException() {
		super("Username já foi registrado");
	}

}

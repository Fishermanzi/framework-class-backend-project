package br.com.espm.felipethiago.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class TrabalhoNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public TrabalhoNotFoundException() {
		super("Trabalho não encontrado");
	}

}

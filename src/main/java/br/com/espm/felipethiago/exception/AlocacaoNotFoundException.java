package br.com.espm.felipethiago.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class AlocacaoNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public AlocacaoNotFoundException() {
		super("Alocação não encotrada");
	}
}

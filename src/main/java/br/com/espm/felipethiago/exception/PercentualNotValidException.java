package br.com.espm.felipethiago.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PercentualNotValidException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public PercentualNotValidException() {
		super("o percentual deve ser entre 0 a 100");
	}

}

package br.com.espm.felipethiago.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class AlocacaoAlreadyExistException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public AlocacaoAlreadyExistException() {
		super("Aluno já foi alocado para o trabalho");
	}
}

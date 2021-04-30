package br.com.espm.felipethiago.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class AlunoNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public AlunoNotFoundException() {
		super("Aluno não encontrado");
	}
}

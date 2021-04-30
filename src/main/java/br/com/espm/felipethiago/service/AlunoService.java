package br.com.espm.felipethiago.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.espm.felipethiago.domain.entity.Aluno;
import br.com.espm.felipethiago.exception.AlunoNotFoundException;
import br.com.espm.felipethiago.exception.UsernameAlreadyExistsException;
import br.com.espm.felipethiago.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	public Aluno criar(final Aluno aluno) {
		if(alunoRepository.existsByUsername(aluno.getUsername())) {
			throw new UsernameAlreadyExistsException();
		}
		
		return alunoRepository.saveAndFlush(aluno);
	}

	public Aluno findById(Long id) {
		return alunoRepository.findById(id).orElseThrow(AlunoNotFoundException::new);
	}

	public List<Aluno> listar() {
		return alunoRepository.findAll();
	}
}

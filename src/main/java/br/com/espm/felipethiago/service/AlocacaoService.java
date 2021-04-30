package br.com.espm.felipethiago.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.espm.felipethiago.domain.entity.Alocacao;
import br.com.espm.felipethiago.domain.entity.Aluno;
import br.com.espm.felipethiago.domain.entity.Trabalho;
import br.com.espm.felipethiago.exception.AlocacaoAlreadyExistException;
import br.com.espm.felipethiago.exception.AlocacaoNotFoundException;
import br.com.espm.felipethiago.exception.AlunoNotFoundException;
import br.com.espm.felipethiago.exception.TrabalhoNotFoundException;
import br.com.espm.felipethiago.repository.AlocacaoRepository;
import br.com.espm.felipethiago.repository.AlunoRepository;
import br.com.espm.felipethiago.repository.TrabalhoRepository;

@Service
public class AlocacaoService {

	@Autowired
	private AlocacaoRepository alocacaoRepository;

	@Autowired
	private TrabalhoRepository trabalhoRepository;

	@Autowired
	private AlunoRepository alunoRepository;

	public Alocacao findById(Long id) {
		return alocacaoRepository.findById(id).orElseThrow(AlocacaoNotFoundException::new);
	}

	public List<Alocacao> listar() {
		return alocacaoRepository.findAll();
	}

	public Alocacao alocar(Long trabalhoId, String username) {

		Trabalho trabalho = trabalhoRepository.findById(trabalhoId).orElseThrow(TrabalhoNotFoundException::new);
		Aluno aluno = alunoRepository.findByUsername(username).orElseThrow(AlunoNotFoundException::new);

		if (alocacaoRepository.existsByTrabalhoIdAndAlunoId(trabalho.getId(), aluno.getId())) {
			throw new AlocacaoAlreadyExistException();
		}
		return alocacaoRepository.saveAndFlush(Alocacao.builder().aluno(aluno).trabalho(trabalho).build());
	}
}

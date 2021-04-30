package br.com.espm.felipethiago.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.espm.felipethiago.domain.entity.Trabalho;
import br.com.espm.felipethiago.exception.PercentualNotValidException;
import br.com.espm.felipethiago.exception.TrabalhoNotFoundException;
import br.com.espm.felipethiago.repository.TrabalhoRepository;

@Service
public class TrabalhoService {

	@Autowired
	private TrabalhoRepository trabalhoRepository;
	
	public Trabalho criar(Trabalho trabalho) {
		return trabalhoRepository.saveAndFlush(trabalho);
	}

	public List<Trabalho> listar() {
		return trabalhoRepository.findAll();
	}

	public Trabalho findById(Long id) {
		return trabalhoRepository.findById(id).orElseThrow(TrabalhoNotFoundException::new);
	}

	public void update(Trabalho trabalho) {
		if(trabalho.getPercentual() > 100 || trabalho.getPercentual() < 0) {
			throw new PercentualNotValidException();
		}
		Trabalho trabalhoBanco = trabalhoRepository.findById(trabalho.getId()).orElseThrow(TrabalhoNotFoundException::new);
		
		trabalho.setTitulo(trabalhoBanco.getTitulo());
		
		trabalhoRepository.saveAndFlush(trabalho);
	}

}

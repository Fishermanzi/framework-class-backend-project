package br.com.espm.felipethiago.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.espm.felipethiago.domain.entity.Trabalho;

public interface TrabalhoRepository extends JpaRepository<Trabalho, Long>{
	
}

package br.com.espm.felipethiago.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.espm.felipethiago.domain.entity.Alocacao;

public interface AlocacaoRepository extends JpaRepository<Alocacao, Long>{

	boolean existsByTrabalhoIdAndAlunoId(Long trabalhoId, Long alunoId);

}

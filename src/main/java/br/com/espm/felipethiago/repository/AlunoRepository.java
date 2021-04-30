package br.com.espm.felipethiago.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.espm.felipethiago.domain.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

	boolean existsByUsername(String username);

	Optional<Aluno> findByUsername(String username);

}

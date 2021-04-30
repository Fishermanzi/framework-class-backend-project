package br.com.espm.felipethiago.domain.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
public class Alocacao extends AbstractEntity<Long> {

	@ManyToOne
	private Aluno aluno;
	
	@ManyToOne
	private Trabalho trabalho;
}

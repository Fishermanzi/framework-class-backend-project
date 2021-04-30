package br.com.espm.felipethiago.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractController {

	protected static final String ID_PATH = "/{id:^(?!count|all).+}";

	@Autowired
	protected ModelMapper mapper;
	
	protected <B, A> List<B> converterClasse(final Iterable<A> modelos, final Class<B> classe) {
		List<B> objConvertidos = new ArrayList<>();
		for (A modelo : modelos) {
			objConvertidos.add(mapper.map(modelo, classe));
		}
		return objConvertidos;
	}
	
	protected <B, A> B converterClasse(final A modelo, final Class<B> classe) {
		return Objects.nonNull(modelo) ? mapper.map(modelo, classe) : null;
	}
	
}

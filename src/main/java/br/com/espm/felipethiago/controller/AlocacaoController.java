package br.com.espm.felipethiago.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.espm.felipethiago.domain.dto.AlocacaoDTO;
import br.com.espm.felipethiago.service.AlocacaoService;

@RestController
@RequestMapping(path = "/alocacao", produces = { MediaType.APPLICATION_JSON_VALUE })
public class AlocacaoController extends AbstractController{
	
	@Autowired
	private AlocacaoService alocacaoService;
	
	@GetMapping(ID_PATH)
	@ResponseStatus(HttpStatus.OK)
	public AlocacaoDTO findById(@PathVariable final Long id) {
		return converterClasse(alocacaoService.findById(id), AlocacaoDTO.class);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<AlocacaoDTO> listar() {
		return converterClasse(alocacaoService.listar(), AlocacaoDTO.class);
	}
	
	@PutMapping("{trabalhoId}/{username}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public String alocar(@PathVariable(value= "trabalhoId",required = true) final Long trabalhoId, @PathVariable(value="username", required = true) String username) {
		return alocacaoService.alocar(trabalhoId, username).getId().toString();
	}
}

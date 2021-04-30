package br.com.espm.felipethiago.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.groups.Default;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.espm.felipethiago.domain.dto.AlunoDTO;
import br.com.espm.felipethiago.domain.entity.Aluno;
import br.com.espm.felipethiago.domain.vo.AlunoVO;
import br.com.espm.felipethiago.service.AlunoService;

@RestController
@RequestMapping(path = "/aluno", produces = { MediaType.APPLICATION_JSON_VALUE })
public class AlunoController extends AbstractController{

	@Autowired
	private AlunoService alunoService;
	
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(HttpStatus.CREATED)
	public String create(@RequestBody @Validated() final AlunoVO alunoVO) {
		return alunoService.criar(converterClasse(alunoVO, Aluno.class)).getId().toString();
	}
	
	@GetMapping(ID_PATH)
	@ResponseStatus(HttpStatus.OK)
	public AlunoDTO findById(@PathVariable final Long id) {
		return converterClasse(alunoService.findById(id), AlunoDTO.class);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<AlunoDTO> listar() {
		return converterClasse(alunoService.listar(), AlunoDTO.class);
	}
}

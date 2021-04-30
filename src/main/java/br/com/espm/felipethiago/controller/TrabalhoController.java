package br.com.espm.felipethiago.controller;

import java.util.List;

import javax.validation.groups.Default;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.espm.felipethiago.domain.dto.TrabalhoDTO;
import br.com.espm.felipethiago.domain.entity.Trabalho;
import br.com.espm.felipethiago.domain.vo.TrabalhoVO;
import br.com.espm.felipethiago.service.TrabalhoService;

@RestController
@RequestMapping(path = "/trabalho", produces = { MediaType.APPLICATION_JSON_VALUE })
public class TrabalhoController extends AbstractController {

	@Autowired
	private TrabalhoService trabalhoService;
	
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(HttpStatus.CREATED)
	public String create(@RequestBody @Validated(value = { Default.class }) final TrabalhoVO trabalhoVO) {
		return trabalhoService.criar(converterClasse(trabalhoVO, Trabalho.class)).getId().toString();
	}
	
	@PutMapping("/percentual/{id}/{percentual}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable(value= "id",required = true) final Long id, @PathVariable(value="percentual", required = true) Float percentual) {
		Trabalho trabalho = Trabalho.builder()
				.id(id)
				.percentual(percentual)
				.build();
		
		trabalhoService.update(trabalho);
	}
	
	@GetMapping(ID_PATH)
	@ResponseStatus(HttpStatus.OK)
	public TrabalhoDTO findById(@PathVariable final Long id) {
		return converterClasse(trabalhoService.findById(id), TrabalhoDTO.class);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<TrabalhoDTO> listar() {
		return converterClasse(trabalhoService.listar(), TrabalhoDTO.class);
	}
}

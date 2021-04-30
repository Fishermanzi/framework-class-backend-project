package br.com.espm.felipethiago.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlunoDTO {

	private Long id;
	
	@JsonIgnore
	private String username;
	
	public String getId() {
		return username;
	}
	public Long getIdDeFato() {
		return id;
	}
}

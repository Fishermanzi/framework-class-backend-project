package br.com.espm.felipethiago.domain.vo;

import javax.validation.constraints.NotNull;

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
public class AlunoVO {
	
	
	private Long id;
	
	@NotNull(message = "{javax.validation.constraints.NotNull.message}")
	private String username;
}

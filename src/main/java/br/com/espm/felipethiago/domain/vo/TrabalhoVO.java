package br.com.espm.felipethiago.domain.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
public class TrabalhoVO {

	@Size(max = 100, min = 0, message= "{br.com.espm.felipethiago.percentual}")
	private Float percentual;
	
	@NotNull
	private String titulo;
}

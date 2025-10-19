package org.serratec.serratec_music.domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "perfil")
public class Perfil {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O telefone não pode ser vazio")
	@Size(max = 15, message = "O telefone não pode ter mais de 15 caracteres")
	private String telefone;
	
	@NotNull(message = "A data de nascimento não pode ser vazia")
	private LocalDate dataNascimento;
	
	@OneToOne(mappedBy = "perfil")
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	public Perfil(Long id,
			@NotBlank(message = "O telefone não pode ser vazio") @Size(max = 15, message = "O telefone não pode ter mais de 15 caracteres") String telefone,
			@NotNull(message = "A data de nascimento não pode ser vazia") LocalDate dataNascimento) {
		super();
		this.id = id;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
	}

	public Perfil() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
}

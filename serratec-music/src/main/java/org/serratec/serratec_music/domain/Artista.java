package org.serratec.serratec_music.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "artista")
public class Artista {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "O nome do artista é obrigatório")
	@Size(max = 30, message = "O nome não pode ter mais de 30 caracteres")
	private String nome;
	
	@NotBlank(message = "A nacionalidade do artista é obrigatória")
	@Size(max = 15, message = "A nacionalidade não pode ter mais de 15 caracteres")
	private String nacionalidade;
	
	@ManyToMany(mappedBy = "artistas")
    private List<Musica> musicas = new ArrayList<>();
	
	public Artista(long id,
			@NotBlank(message = "O nome do artista é obrigatório") @Size(max = 30, message = "O nome não pode ter mais de 30 caracteres") String nome,
			@NotBlank(message = "A nacionalidade do artista é obrigatória") @Size(max = 15, message = "A nacionalidade não pode ter mais de 15 caracteres") String nacionalidade,
			List<Musica> musicas) {
		super();
		this.id = id;
		this.nome = nome;
		this.nacionalidade = nacionalidade;
		this.musicas = musicas;
	}

	public Artista() {
	}

	public List<Musica> getMusicas() {
		return musicas;
	}

	public void setMusicas(List<Musica> musicas) {
		this.musicas = musicas;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	
	
}

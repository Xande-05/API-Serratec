package org.serratec.serratec_music.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "playlist")
public class PlayList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "O nome não pode ser vazio")
	@Size(max = 30, message = "O nome não pode ter mais de 30 caracteres")
	private String nome;
	
	@NotBlank(message = "A descrição não pode ser vazia")
	@Size(max = 100, message = "A descrição não pode ter mais de 100 caracteres")
	private String descricao;
	
	@ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
	
	public PlayList(long id,
			@NotBlank(message = "O nome não pode ser vazio") @Size(max = 30, message = "O nome não pode ter mais de 30 caracteres") String nome,
			@NotBlank(message = "A descrição não pode ser vazia") @Size(max = 100, message = "A descrição não pode ter mais de 100 caracteres") String descricao,
			Usuario usuario, List<Musica> musicas) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.usuario = usuario;
		this.musicas = musicas;
	}
	
	public PlayList() {
	}
	
	@ManyToMany
    @JoinTable(
        name = "playlist_musica",
        joinColumns = @JoinColumn(name = "playlist_id"),
        inverseJoinColumns = @JoinColumn(name = "musica_id")
    )
    @JsonIgnoreProperties("playlists") 
    private List<Musica> musicas = new ArrayList<>();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}

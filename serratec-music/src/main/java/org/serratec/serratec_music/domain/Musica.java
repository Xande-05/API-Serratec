package org.serratec.serratec_music.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "musica")
public class Musica {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "O título não pode ser vazio")
	@Size(max = 30, message = "O título não pode ter mais de 30 caracteres")
	private String titulo;
	
	@NotNull(message = "A duração em minutos não pode ser nula")
	private Integer minutos;
	
	@Enumerated(EnumType.STRING)
    private GeneroMusical genero;
	
	public Musica(long id,
			@NotBlank(message = "O título não pode ser vazio") @Size(max = 30, message = "O título não pode ter mais de 30 caracteres") String titulo,
			@NotNull(message = "A duração em minutos não pode ser nula") Integer minutos, GeneroMusical genero,
			List<Artista> artistas, List<PlayList> playlists) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.minutos = minutos;
		this.genero = genero;
		this.artistas = artistas;
		this.playlists = playlists;
	}
	
	public Musica() {
	}
	
	@ManyToMany
    @JoinTable(
        name = "musica_artista",
        joinColumns = @JoinColumn(name = "musica_id"),
        inverseJoinColumns = @JoinColumn(name = "artista_id")
    )
    private List<Artista> artistas = new ArrayList<>();
	
	 @ManyToMany(mappedBy = "musicas")
	    @JsonIgnoreProperties("musicas")
	    private List<PlayList> playlists = new ArrayList<>();

	public List<PlayList> getPlaylists() {
		return playlists;
	}

	 public void setPlaylists(List<PlayList> playlists) {
		 this.playlists = playlists;
	 }

	public List<Artista> getArtistas() {
		return artistas;
	}

	public void setArtistas(List<Artista> artistas) {
		this.artistas = artistas;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getMinutos() {
		return minutos;
	}

	public void setMinutos(Integer minutos) {
		this.minutos = minutos;
	}

	public GeneroMusical getGenero() {
		return genero;
	}

	public void setGenero(GeneroMusical genero) {
		this.genero = genero;
	}
	
}

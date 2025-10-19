package org.serratec.serratec_music.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O nome não pode ser vazio")
	@Size(max = 30, message = "O nome não pode ter mais de 30 caracteres")
	private String nome;
	
	@NotBlank(message = "O email não pode ser vazio")
	@Email(message = "O email deve ser válido")
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "perfil_id")
    private Perfil perfil;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlayList> playlists = new ArrayList<>();
	
	public Usuario(Long id,
			@NotBlank(message = "O nome não pode ser vazio") @Size(max = 30, message = "O nome não pode ter mais de 30 caracteres") String nome,
			@NotBlank(message = "O email não pode ser vazio") @Email(message = "O email deve ser válido") String email,
			Perfil perfil, List<PlayList> playlists) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.perfil = perfil;
		this.playlists = playlists;
	}

	public Usuario() {
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public List<PlayList> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(List<PlayList> playlists) {
		this.playlists = playlists;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}

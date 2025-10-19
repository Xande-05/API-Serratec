package org.serratec.serratec_music.controller;

import java.util.List;

import org.serratec.serratec_music.domain.Usuario;
import org.serratec.serratec_music.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioCntroller {

	private static final String Usuario = null;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public List<Usuario> listarUsuartios(){
		return usuarioRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Usuario buscarPorId (@PathVariable long id) {
		return usuarioRepository.findById(id).orElse(null);
	}
	
	@PostMapping
    public ResponseEntity<Usuario> criarUsuario(@Valid @RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }
	
	@PutMapping("/{id}")
	public Usuario atualizrUsuario (@PathVariable Long id, @RequestBody Usuario novoUsuario) {
		Usuario usuario = usuarioRepository.findById(id).orElse(null);
		if (Usuario != null) {
			usuario.setNome(novoUsuario.getNome());
			usuario.setEmail(novoUsuario.getEmail());
			usuarioRepository.save(usuario);
		}
		return usuario;
	}
	
	@DeleteMapping("/{id}")
	public void deleteUsuario (@PathVariable Long id) {
		usuarioRepository.deleteById(id);
	}
}

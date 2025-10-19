package org.serratec.serratec_music.controller;

import java.util.List;

import org.serratec.serratec_music.domain.Artista;
import org.serratec.serratec_music.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/artistas")
public class ArtistaController {
	
	private static final String Artista = null;
	
	@Autowired
	private ArtistaRepository ArtistaRepository;	
	
	@GetMapping
	public List<Artista> listarArtistas(){
		return ArtistaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Artista buscarPorId (@PathVariable long id) {
		return ArtistaRepository.findById(id).orElse(null);
	}
	
	@PostMapping
	public Artista criarArtista (@Valid @PathVariable Artista artista) {
		return ArtistaRepository.save(artista);
	}	
	
	@PutMapping("/{id}")
	public Artista atualizarArtista(@PathVariable Long id, @RequestBody Artista novoArtista) {
		Artista artista = ArtistaRepository.findById(id).orElse(null);
		if (Artista != null) {
			artista.setNome(novoArtista.getNome());
			artista.setNacionalidade(novoArtista.getNacionalidade());
		}
		return artista;
	}
	
	@DeleteMapping("/{id}")
	public void deletarArtista(@PathVariable Long id) {
		ArtistaRepository.deleteById(id);
	}
}

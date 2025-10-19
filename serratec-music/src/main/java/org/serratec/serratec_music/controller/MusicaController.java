package org.serratec.serratec_music.controller;

import java.util.List;

import org.serratec.serratec_music.domain.Musica;
import org.serratec.serratec_music.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/musicas")
public class MusicaController {
	
	private static final String Musica = null;
	
	@Autowired
	private MusicaRepository MusicaRepository;
	
	@GetMapping
	public List<Musica> listarMusicas(){
		return MusicaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Musica buscarPorId (@PathVariable Long id) {
		return MusicaRepository.findById(id).orElse(null);
	}
	
	@PostMapping
	public Musica criarMusica (@Valid @RequestBody Musica musica) {
		return MusicaRepository.save(musica);
	}
	
	@PutMapping("/{id}")
	public Musica atualizarMusica(@PathVariable Long id, @RequestBody Musica novaMusica) {
		Musica musica = MusicaRepository.findById(id).orElse(null);
		if (Musica != null) {
			musica.setTitulo(novaMusica.getTitulo());
			musica.setMinutos(novaMusica.getMinutos());
			musica.setGenero(novaMusica.getGenero());
			MusicaRepository.save(musica);
		}
		return musica;
	}
	
	@DeleteMapping("/{id}")
	public void deletarMusica(@PathVariable Long id) {
		MusicaRepository.deleteById(id);
	}
}

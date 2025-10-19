package org.serratec.serratec_music.controller;

import java.util.List;

import org.serratec.serratec_music.domain.PlayList;
import org.serratec.serratec_music.repository.PlayListRepository;
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
@RequestMapping("/playlists")
public class PlayListController {
	
	private static final String PlayList = null;	
	
	@Autowired
	private PlayListRepository PlayListRepository;
	
	@GetMapping
	public List<PlayList> listarPlayLists(){
		return PlayListRepository.findAll();
	}

	@GetMapping("/{id}")
	public PlayList buscarPorId(@PathVariable Long id) {
		return PlayListRepository.findById(id).orElse(null);	
	}
	
	@PostMapping
	public PlayList criarPlayList(@Valid @RequestBody PlayList playlist) {
		return PlayListRepository.save(playlist);
	}	
	
	@PutMapping("/{id}")
	public PlayList atualizarPlayList(@PathVariable Long id, @RequestBody PlayList novaPlayList) {
		PlayList playlist = PlayListRepository.findById(id).orElse(null);
		if (PlayList != null) {
			playlist.setNome(novaPlayList.getNome());
			playlist.setDescricao(novaPlayList.getDescricao());
			PlayListRepository.save(playlist);
		}
		return playlist;
	}
	
	@DeleteMapping("/{id}")
	public void deletePlaylist (@PathVariable Long id) {
		PlayListRepository.deleteById(id);
	}
}

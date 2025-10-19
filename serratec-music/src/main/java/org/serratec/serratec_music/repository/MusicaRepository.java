package org.serratec.serratec_music.repository;

import java.util.List;

import org.serratec.serratec_music.domain.GeneroMusical;
import org.serratec.serratec_music.domain.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Long> {
	
	List<Musica> findByGenero(GeneroMusical genero);
}

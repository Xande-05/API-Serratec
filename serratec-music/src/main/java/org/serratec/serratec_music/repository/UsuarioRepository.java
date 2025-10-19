package org.serratec.serratec_music.repository;

import org.serratec.serratec_music.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}

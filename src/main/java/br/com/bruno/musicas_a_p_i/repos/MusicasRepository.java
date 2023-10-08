package br.com.bruno.musicas_a_p_i.repos;

import br.com.bruno.musicas_a_p_i.domain.Musicas;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MusicasRepository extends JpaRepository<Musicas, Long> {
}

package br.com.bruno.musicas.repos;

import br.com.bruno.musicas.domain.Musicas;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MusicasRepository extends JpaRepository<Musicas, Integer> {
}

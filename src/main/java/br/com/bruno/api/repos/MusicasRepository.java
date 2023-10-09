package br.com.bruno.api.repos;

import br.com.bruno.api.domain.Musicas;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MusicasRepository extends JpaRepository<Musicas, Integer> {
}

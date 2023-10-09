package br.com.bruno.musicas_a_p_i.service;

import br.com.bruno.musicas_a_p_i.domain.Musicas;
import br.com.bruno.musicas_a_p_i.model.MusicasDTO;
import br.com.bruno.musicas_a_p_i.repos.MusicasRepository;
import br.com.bruno.musicas_a_p_i.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class MusicasService {

    private final MusicasRepository musicasRepository;

    public MusicasService(final MusicasRepository musicasRepository) {
        this.musicasRepository = musicasRepository;
    }

    public List<MusicasDTO> findAll() {
        final List<Musicas> musicases = musicasRepository.findAll(Sort.by("id"));
        return musicases.stream()
                .map(musicas -> mapToDTO(musicas, new MusicasDTO()))
                .toList();
    }

    public MusicasDTO get(final Integer id) {
        return musicasRepository.findById(id)
                .map(musicas -> mapToDTO(musicas, new MusicasDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Integer create(final MusicasDTO musicasDTO) {
        final Musicas musicas = new Musicas();
        mapToEntity(musicasDTO, musicas);
        return musicasRepository.save(musicas).getId();
    }

    public void update(final Integer id, final MusicasDTO musicasDTO) {
        final Musicas musicas = musicasRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(musicasDTO, musicas);
        musicasRepository.save(musicas);
    }

    public void delete(final Integer id) {
        musicasRepository.deleteById(id);
    }

    private MusicasDTO mapToDTO(final Musicas musicas, final MusicasDTO musicasDTO) {
        musicasDTO.setId(musicas.getId());
        musicasDTO.setTitulo(musicas.getTitulo());
        musicasDTO.setArtista(musicas.getArtista());
        musicasDTO.setDuracao(musicas.getDuracao());
        musicasDTO.setAlbum(musicas.getAlbum());
        return musicasDTO;
    }

    private Musicas mapToEntity(final MusicasDTO musicasDTO, final Musicas musicas) {
        musicas.setTitulo(musicasDTO.getTitulo());
        musicas.setArtista(musicasDTO.getArtista());
        musicas.setDuracao(musicasDTO.getDuracao());
        musicas.setAlbum(musicasDTO.getAlbum());
        return musicas;
    }

}

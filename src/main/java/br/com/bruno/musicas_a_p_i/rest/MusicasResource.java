package br.com.bruno.musicas_a_p_i.rest;

import br.com.bruno.musicas_a_p_i.model.MusicasDTO;
import br.com.bruno.musicas_a_p_i.service.MusicasService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import java.util.List;
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


@RestController
@RequestMapping(value = "/api/musicass", produces = MediaType.APPLICATION_JSON_VALUE)
public class MusicasResource {

    private final MusicasService musicasService;

    public MusicasResource(final MusicasService musicasService) {
        this.musicasService = musicasService;
    }

    @GetMapping
    public ResponseEntity<List<MusicasDTO>> getAllMusicass() {
        return ResponseEntity.ok(musicasService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MusicasDTO> getMusicas(@PathVariable(name = "id") final Integer id) {
        return ResponseEntity.ok(musicasService.get(id));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Integer> createMusicas(@RequestBody @Valid final MusicasDTO musicasDTO) {
        final Integer createdId = musicasService.create(musicasDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Integer> updateMusicas(@PathVariable(name = "id") final Integer id,
            @RequestBody @Valid final MusicasDTO musicasDTO) {
        musicasService.update(id, musicasDTO);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteMusicas(@PathVariable(name = "id") final Integer id) {
        musicasService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

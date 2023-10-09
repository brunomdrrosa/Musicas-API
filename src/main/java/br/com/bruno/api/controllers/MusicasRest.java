package br.com.bruno.api.controllers;

import br.com.bruno.api.model.MusicasDTO;
import br.com.bruno.api.service.MusicasService;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping(value = "/api/musicas", produces = MediaType.APPLICATION_JSON_VALUE)
public class MusicasRest {

    private final MusicasService musicasService;

    public MusicasRest(final MusicasService musicasService) {
        this.musicasService = musicasService;
    }

    @ApiOperation(value= "Buscar todas as músicas disponíveis no sistema.")
    @GetMapping
    public ResponseEntity<List<MusicasDTO>> getAllMusicas() {
        return ResponseEntity.ok(musicasService.findAll());
    }

    @ApiOperation(value= "Buscar uma música por ID.")
    @GetMapping("/{id}")
    public ResponseEntity<MusicasDTO> getMusicas(@PathVariable(name = "id") final Integer id) {
        return ResponseEntity.ok(musicasService.get(id));
    }

    @ApiOperation(value= "Adicionar uma nova música no sistema.")
    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Integer> createMusicas(@RequestBody @Valid final MusicasDTO musicasDTO) {
        final Integer createdId = musicasService.create(musicasDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @ApiOperation(value= "Atualizar uma música do sistema.")
    @PutMapping("/{id}")
    public ResponseEntity<Integer> updateMusicas(@PathVariable(name = "id") final Integer id,
            @RequestBody @Valid final MusicasDTO musicasDTO) {
        musicasService.update(id, musicasDTO);
        return ResponseEntity.ok(id);
    }

    @ApiOperation(value= "Remover uma música do sistema.")
    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteMusicas(@PathVariable(name = "id") final Integer id) {
        musicasService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

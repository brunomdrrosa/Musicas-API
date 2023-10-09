package br.com.bruno.musicas.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class MusicasDTO {

    private Integer id;

    @NotNull
    @Size(max = 255)
    private String titulo;

    @NotNull
    @Size(max = 255)
    private String artista;

    @NotNull
    private Integer duracao;

    @Size(max = 255)
    private String album;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(final String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(final String artista) {
        this.artista = artista;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(final Integer duracao) {
        this.duracao = duracao;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(final String album) {
        this.album = album;
    }

}

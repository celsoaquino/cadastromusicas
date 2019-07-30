package br.com.celsoaquino.service;

import br.com.celsoaquino.domain.Musica;

import java.util.List;

public interface MusicaService {

    void salvar(Musica musica, Long playlistId);
    List<Musica> recuperarPorPlaylist(Long playlistId);
    Musica recuperarPorPlaylistIdEMusicaId
            (Long playlistId, Long musicaId);
    void atualizar(Musica musica, Long playlistId);
    void excluir(Long playlistId, Long musicaId);
}

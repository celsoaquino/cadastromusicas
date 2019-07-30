package br.com.celsoaquino.repository;

import br.com.celsoaquino.domain.Musica;

import java.util.List;

public interface MusicaRepository {

    void salvar(Musica musica);
    List<Musica> recuperarPorPlaylist(Long playlistId);
    Musica recuperarPorPlaylistIdEMusicaId(Long playlistId, Long musicaId);
    void atualizar(Musica musica);
    void excluir(Long musicaId);
}

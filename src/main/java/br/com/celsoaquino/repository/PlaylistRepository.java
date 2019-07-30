package br.com.celsoaquino.repository;

import br.com.celsoaquino.domain.Playlist;

import java.util.List;

public interface PlaylistRepository {

    void salvar(Playlist playlist);
    List<Playlist> recuperar();
    Playlist recuperarPoId(Long id);
    void atualizar(Playlist playlist);
    void excluir(Long id);
}

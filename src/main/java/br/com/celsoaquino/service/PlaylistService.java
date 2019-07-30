package br.com.celsoaquino.service;

import br.com.celsoaquino.domain.Playlist;

import java.util.List;

public interface PlaylistService {

    void salvar(Playlist playlist);
    List<Playlist> recuperar();
    Playlist recuperarPoId(Long id);
    void atualizar(Playlist playlist);
    void excluir(Long id);
}

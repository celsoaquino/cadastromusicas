package br.com.celsoaquino.service.impl;

import br.com.celsoaquino.domain.Playlist;
import br.com.celsoaquino.repository.PlaylistRepository;
import br.com.celsoaquino.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PlaylistImplService implements PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    @Override
    public void salvar(Playlist playlist) {
        playlistRepository.salvar(playlist);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Playlist> recuperar() {
        return playlistRepository.recuperar();
    }

    @Override
    @Transactional(readOnly = true)
    public Playlist recuperarPoId(Long id) {
        return playlistRepository.recuperarPoId(id);
    }

    @Override
    public void atualizar(Playlist playlist) {
        playlistRepository.atualizar(playlist);
    }

    @Override
    public void excluir(Long id) {
        playlistRepository.excluir(id);
    }
}

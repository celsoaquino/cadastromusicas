package br.com.celsoaquino.service.impl;

import br.com.celsoaquino.domain.Musica;
import br.com.celsoaquino.repository.MusicaRepository;
import br.com.celsoaquino.service.MusicaService;
import br.com.celsoaquino.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MusicaServiceImpl implements MusicaService  {

    @Autowired
    private MusicaRepository musicaRepository;

    @Autowired
    private PlaylistService playlistService;

    @Override
    public void salvar(Musica musica, Long playlistId) {
        musica.setPlaylist(playlistService.recuperarPoId(playlistId));
        musicaRepository.salvar(musica);
    }

    @Override
    public List<Musica> recuperarPorPlaylist(Long playlistId) {
        return musicaRepository.recuperarPorPlaylist(playlistId);
    }

    @Override
    public Musica recuperarPorPlaylistIdEMusicaId(Long playlistId, Long musicaId) {
        return musicaRepository.recuperarPorPlaylistIdEMusicaId
                (playlistId, musicaId);
    }

    @Override
    public void atualizar(Musica musica, Long playlistId) {
        musica.setPlaylist(playlistService.recuperarPoId(playlistId));
        musicaRepository.atualizar(musica);
    }

    @Override
    public void excluir(Long playlistId, Long musicaId) {
        musicaRepository.excluir(recuperarPorPlaylistIdEMusicaId
                (playlistId, musicaId).getId());
    }
}

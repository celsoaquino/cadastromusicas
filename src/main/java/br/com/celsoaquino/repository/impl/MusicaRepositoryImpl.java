package br.com.celsoaquino.repository.impl;

import br.com.celsoaquino.domain.Musica;
import br.com.celsoaquino.repository.MusicaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MusicaRepositoryImpl implements MusicaRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void salvar(Musica musica) {
        em.persist(musica);
    }

    @Override
    public List<Musica> recuperarPorPlaylist(Long playlistId) {
        return em.createQuery("select m from Musica m where m.playlist.id = :playlistId", Musica.class)
                .setParameter("playlistId", playlistId)
                .getResultList();
    }

    @Override
    public Musica recuperarPorPlaylistIdEMusicaId(Long playlistId, Long musicaId) {
        return em.createQuery("select m from Musica m where m.playlist.id = :playlistId and m.id = :musicaId", Musica.class)
                .setParameter("playlistId", playlistId)
                .setParameter("musicaId", musicaId)
                .getSingleResult();
    }


    @Override
    public void atualizar(Musica musica) {
        em.merge(musica);
    }

    @Override
    public void excluir(Long musicaId) {
        em.remove(em.getReference(Musica.class, musicaId));
    }
}

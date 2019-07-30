package br.com.celsoaquino.repository.impl;

import br.com.celsoaquino.domain.Playlist;
import br.com.celsoaquino.repository.PlaylistRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PlaylistRepositoryImpl implements PlaylistRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void salvar(Playlist playlist) {
        em.persist(playlist);
    }

    @Override
    public List<Playlist> recuperar() {
        return em.createQuery("select p from Playlist p", Playlist.class).getResultList();
    }

    @Override
    public Playlist recuperarPoId(Long id) {
        return em.find(Playlist.class, id);
    }

    @Override
    public void atualizar(Playlist playlist) {
        em.merge(playlist);
    }

    @Override
    public void excluir(Long id) {
        em.remove(em.getReference(Playlist.class, id));
    }
}

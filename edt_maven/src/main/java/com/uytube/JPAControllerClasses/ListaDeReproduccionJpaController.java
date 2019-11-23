/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uytube.JPAControllerClasses;

import com.uytube.JPAControllerClasses.exceptions.NonexistentEntityException;
import com.uytube.Logica.Clases.ListaDeReproduccion;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Juan
 */
public class ListaDeReproduccionJpaController implements Serializable {

    public ListaDeReproduccionJpaController() {
        this.emf = Persistence.createEntityManagerFactory(NombreManejador.getNombreManejador());
    }
    public ListaDeReproduccionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ListaDeReproduccion listaDeReproduccion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(listaDeReproduccion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ListaDeReproduccion listaDeReproduccion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            listaDeReproduccion = em.merge(listaDeReproduccion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = listaDeReproduccion.getId();
                if (findListaDeReproduccion(id) == null) {
                    throw new NonexistentEntityException("The listaDeReproduccion with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ListaDeReproduccion listaDeReproduccion;
            try {
                listaDeReproduccion = em.getReference(ListaDeReproduccion.class, id);
                listaDeReproduccion.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The listaDeReproduccion with id " + id + " no longer exists.", enfe);
            }
            em.remove(listaDeReproduccion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ListaDeReproduccion> findListaDeReproduccionEntities() {
        return findListaDeReproduccionEntities(true, -1, -1);
    }

    public List<ListaDeReproduccion> findListaDeReproduccionEntities(int maxResults, int firstResult) {
        return findListaDeReproduccionEntities(false, maxResults, firstResult);
    }

    private List<ListaDeReproduccion> findListaDeReproduccionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ListaDeReproduccion.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public ListaDeReproduccion findListaDeReproduccion(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ListaDeReproduccion.class, id);
        } finally {
            em.close();
        }
    }

    public int getListaDeReproduccionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ListaDeReproduccion> rt = cq.from(ListaDeReproduccion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

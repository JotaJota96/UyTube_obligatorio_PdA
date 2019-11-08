/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAControllerClasses;

import JPAControllerClasses.exceptions.NonexistentEntityException;
import Logica.Clases.ListaDeReproduccionHistorial;
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
public class ListaDeReproduccionHistorialJpaController implements Serializable {

    public ListaDeReproduccionHistorialJpaController() {
        this.emf = Persistence.createEntityManagerFactory(NombreManejador.getNombreManejador());
    }
    public ListaDeReproduccionHistorialJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ListaDeReproduccionHistorial listaDeReproduccionHistorial) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(listaDeReproduccionHistorial);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ListaDeReproduccionHistorial listaDeReproduccionHistorial) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            listaDeReproduccionHistorial = em.merge(listaDeReproduccionHistorial);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = listaDeReproduccionHistorial.getId();
                if (findListaDeReproduccionHistorial(id) == null) {
                    throw new NonexistentEntityException("The listaDeReproduccionHistorial with id " + id + " no longer exists.");
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
            ListaDeReproduccionHistorial listaDeReproduccionHistorial;
            try {
                listaDeReproduccionHistorial = em.getReference(ListaDeReproduccionHistorial.class, id);
                listaDeReproduccionHistorial.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The listaDeReproduccionHistorial with id " + id + " no longer exists.", enfe);
            }
            em.remove(listaDeReproduccionHistorial);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ListaDeReproduccionHistorial> findListaDeReproduccionHistorialEntities() {
        return findListaDeReproduccionHistorialEntities(true, -1, -1);
    }

    public List<ListaDeReproduccionHistorial> findListaDeReproduccionHistorialEntities(int maxResults, int firstResult) {
        return findListaDeReproduccionHistorialEntities(false, maxResults, firstResult);
    }

    private List<ListaDeReproduccionHistorial> findListaDeReproduccionHistorialEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ListaDeReproduccionHistorial.class));
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

    public ListaDeReproduccionHistorial findListaDeReproduccionHistorial(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ListaDeReproduccionHistorial.class, id);
        } finally {
            em.close();
        }
    }

    public int getListaDeReproduccionHistorialCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ListaDeReproduccionHistorial> rt = cq.from(ListaDeReproduccionHistorial.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAControllerClasses;

import JPAControllerClasses.exceptions.NonexistentEntityException;
import Logica.Clases.RegistroHistorial;
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
public class RegistroHistorialJpaController implements Serializable {

    public RegistroHistorialJpaController() {
        this.emf = Persistence.createEntityManagerFactory(NombreManejador.getNombreManejador());
    }
    public RegistroHistorialJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(RegistroHistorial registroHistorial) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(registroHistorial);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(RegistroHistorial registroHistorial) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            registroHistorial = em.merge(registroHistorial);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = registroHistorial.getId();
                if (findRegistroHistorial(id) == null) {
                    throw new NonexistentEntityException("The registroHistorial with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            RegistroHistorial registroHistorial;
            try {
                registroHistorial = em.getReference(RegistroHistorial.class, id);
                registroHistorial.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The registroHistorial with id " + id + " no longer exists.", enfe);
            }
            em.remove(registroHistorial);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<RegistroHistorial> findRegistroHistorialEntities() {
        return findRegistroHistorialEntities(true, -1, -1);
    }

    public List<RegistroHistorial> findRegistroHistorialEntities(int maxResults, int firstResult) {
        return findRegistroHistorialEntities(false, maxResults, firstResult);
    }

    private List<RegistroHistorial> findRegistroHistorialEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(RegistroHistorial.class));
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

    public RegistroHistorial findRegistroHistorial(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(RegistroHistorial.class, id);
        } finally {
            em.close();
        }
    }

    public int getRegistroHistorialCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<RegistroHistorial> rt = cq.from(RegistroHistorial.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAControllerClasses;

import JPAControllerClasses.exceptions.NonexistentEntityException;
import JPAControllerClasses.exceptions.PreexistingEntityException;
import Logica.Clases.ImagenUsuario;
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
public class ImagenUsuarioJpaController implements Serializable {

    public ImagenUsuarioJpaController() {
        this.emf = Persistence.createEntityManagerFactory(NombreManejador.getNombreManejador());
    }
    public ImagenUsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ImagenUsuario imagenUsuario) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(imagenUsuario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findImagenUsuario(imagenUsuario.getNickname()) != null) {
                throw new PreexistingEntityException("ImagenUsuario " + imagenUsuario + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ImagenUsuario imagenUsuario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            imagenUsuario = em.merge(imagenUsuario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = imagenUsuario.getNickname();
                if (findImagenUsuario(id) == null) {
                    throw new NonexistentEntityException("The imagenUsuario with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ImagenUsuario imagenUsuario;
            try {
                imagenUsuario = em.getReference(ImagenUsuario.class, id);
                imagenUsuario.getNickname();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The imagenUsuario with id " + id + " no longer exists.", enfe);
            }
            em.remove(imagenUsuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ImagenUsuario> findImagenUsuarioEntities() {
        return findImagenUsuarioEntities(true, -1, -1);
    }

    public List<ImagenUsuario> findImagenUsuarioEntities(int maxResults, int firstResult) {
        return findImagenUsuarioEntities(false, maxResults, firstResult);
    }

    private List<ImagenUsuario> findImagenUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ImagenUsuario.class));
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

    public ImagenUsuario findImagenUsuario(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ImagenUsuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getImagenUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ImagenUsuario> rt = cq.from(ImagenUsuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

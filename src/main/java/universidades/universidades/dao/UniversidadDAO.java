package universidades.universidades.dao;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import universidades.universidades.model.Universidad;

@Stateless
public class UniversidadDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Universidad universidad) {
		em.persist(universidad);
		
	}
	
	public void update(Universidad universidad) {
		em.merge(universidad);
			
	}
	
	public void remove(int codigo) {
		Universidad universidad = em.find(Universidad.class, codigo);
		em.remove(universidad);
		
	}
	
	public Universidad read (int codigo) {
		Universidad universidad = em.find(Universidad.class, codigo);
		
		return universidad;
		
	}
	
	public List<Universidad> getAll(){
		String jpql = "SELECT m FROM Universidad m";//Aqui nos referimos a las entidades no a la base de daros, es sensible a mayuscular y minusculas
		Query q = em.createQuery(jpql, Universidad.class);
		return q.getResultList();
	}

}

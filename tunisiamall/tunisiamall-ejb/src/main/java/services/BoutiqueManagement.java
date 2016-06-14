package services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Boutique;

/**
 * Session Bean implementation class BoutiqueManagement
 */
@Stateless
@LocalBean
public class BoutiqueManagement implements BoutiqueManagementRemote, BoutiqueManagementLocal {

	@PersistenceContext
	EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public BoutiqueManagement() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean addBoutique(Boutique bo) {
		try{
			entityManager.persist(bo);
			
			return true;
		}catch(Exception e){
			System.err.println("Problem adding boutique ...");
		}
		return false;
	}

	@Override
	public boolean updateBoutique(Boutique bo) {
		try {
			entityManager.merge(bo);
			return true;
		} catch (Exception e) {
			System.err.println("Problem updating ...");
		}
		return false;
	}

	@Override
	public boolean deleteBoutique(Boutique bo) {
		try {
			entityManager.remove(entityManager.merge(bo));
			return true;
		} catch (Exception e) {
			System.err.println("Problem deleting ...");
		}
		return false;
	}

}

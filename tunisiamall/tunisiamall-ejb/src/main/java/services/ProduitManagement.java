package services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Boutique;
import entities.Categorie;
import entities.Commande;
import entities.Produit;

/**
 * Session Bean implementation class ProduitManagement
 */
@Stateless
@LocalBean
public class ProduitManagement implements ProduitManagementRemote, ProduitManagementLocal {

	@PersistenceContext
	EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public ProduitManagement() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean addProduitBoutique(Produit pr, Boutique bo, Categorie ca) {

		try{
			pr.setCategorie(ca);
			pr.setBoutique(bo);
			entityManager.persist(pr);
			
			return true;
		}catch(Exception e){
			System.err.println("Problem during adding client ...");
		}
		return false;

	}

	@Override
	public boolean deleteProduitBoutique(Produit pr) {
		
		try {
			entityManager.remove(entityManager.merge(pr));
			return true;
		} catch (Exception e) {
			System.err.println("Problem deleting ...");
		}
		return false;
		
	}

	@Override
	public boolean updateProduitBoutique(Produit pr) {
		try {
			entityManager.merge(pr);
			return true;
		} catch (Exception e) {
			System.err.println("Problem updating ...");
		}
		return false;
	}

	@Override
	public boolean addProduitCommande(Produit pr, Commande co) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProduitCommande(Produit pr, Commande co) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCategorieProduit(Produit pr, Categorie ca) {
		
		try {
			pr.setCategorie(ca);
			entityManager.merge(pr);
			return true;
		} catch (Exception e) {
			System.err.println("Problem updating ...");
		}
		return false;
	}

}

package services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Commande;
import entities.Livraison;
import entities.Produit;

/**
 * Session Bean implementation class CommandeManagement
 */
@Stateless
@LocalBean
public class CommandeManagement implements CommandeManagementRemote, CommandeManagementLocal {

	@PersistenceContext
	EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public CommandeManagement() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean addProduitCmd(Commande co, Produit pr) {

		try{
			co.getProduits().add(pr);
			entityManager.persist(co);
			
			return true;
		}catch(Exception e){
			System.err.println("Problem adding produit in commande ...");
		}
		return false;
	}

	@Override
	public boolean deleteProduitCmd(Commande co, Produit pr) {
		try{
			co.getProduits().remove(pr);
			
			return true;
		}catch(Exception e){
			System.err.println("Problem deleting produit in commande ...");
		}
		return false;
	}

	@Override
	public boolean addCommandeLivraison(Commande co, Livraison li) {
		try{
			li.setCommande(co);
			entityManager.persist(li);
			
			return true;
		}catch(Exception e){
			System.err.println("Problem adding produit in commande ...");
		}
		return false;
	}

	@Override
	public boolean changerStatutLivraisonValide(Livraison li) {
		li.setStatutcmd("Livrée");
		try {
			entityManager.merge(li);
			return true;
		} catch (Exception e) {
			System.err.println("Problem updating ...");
		}
		return false;
		
	}

	

}

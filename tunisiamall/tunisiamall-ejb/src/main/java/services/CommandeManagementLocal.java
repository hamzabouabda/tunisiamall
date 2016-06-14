package services;

import javax.ejb.Local;

import entities.Commande;
import entities.Livraison;
import entities.Produit;

@Local
public interface CommandeManagementLocal {
	
	public boolean addProduitCmd(Commande co,Produit pr);
	public boolean deleteProduitCmd(Commande co,Produit pr);
	public boolean addCommandeLivraison(Commande co, Livraison li);
	public boolean changerStatutLivraisonValide(Livraison li);
	

}

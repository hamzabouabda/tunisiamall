package services;

import javax.ejb.Remote;

import entities.Commande;
import entities.Livraison;
import entities.Produit;

@Remote
public interface CommandeManagementRemote {
	
	public boolean addProduitCmd(Commande co,Produit pr);
	public boolean deleteProduitCmd(Commande co,Produit pr);
	public boolean addCommandeLivraison(Commande co, Livraison li);
	public boolean changerStatutLivraisonValide(Livraison li);

}

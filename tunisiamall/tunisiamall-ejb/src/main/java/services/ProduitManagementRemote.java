package services;

import javax.ejb.Remote;

import entities.Boutique;
import entities.Categorie;
import entities.Commande;
import entities.Produit;

@Remote
public interface ProduitManagementRemote {
	
	public boolean addProduitBoutique(Produit pr , Boutique bo, Categorie ca);
	public boolean deleteProduitBoutique(Produit pr);
	public boolean updateProduitBoutique(Produit pr);
	public boolean updateCategorieProduit(Produit pr, Categorie ca);
	public boolean addProduitCommande(Produit pr, Commande co);
	public boolean deleteProduitCommande(Produit pr, Commande co);


}

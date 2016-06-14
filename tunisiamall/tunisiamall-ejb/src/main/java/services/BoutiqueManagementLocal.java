package services;

import javax.ejb.Local;

import entities.Boutique;

@Local
public interface BoutiqueManagementLocal {
	
	public boolean addBoutique(Boutique bo);
	public boolean updateBoutique(Boutique bo);
	public boolean deleteBoutique(Boutique bo);

}

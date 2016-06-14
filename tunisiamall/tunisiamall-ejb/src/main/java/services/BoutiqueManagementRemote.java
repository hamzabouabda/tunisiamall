package services;

import javax.ejb.Remote;

import entities.Boutique;

@Remote
public interface BoutiqueManagementRemote {
	
	public boolean addBoutique(Boutique bo);
	public boolean updateBoutique(Boutique bo);
	public boolean deleteBoutique(Boutique bo);

}

package services;

import java.util.List;

import javax.ejb.Local;

import entities.Adresse;
import entities.Client;
import entities.Contact;

@Local
public interface ClientManagementLocal {
	
	public boolean addClient(Client c);
	public boolean updateClient(Client c);
	public boolean deleteClient(Client c);
	public Client searchClientByid(int id);
	public List<Contact> getContactsClient(Client client);
	public List<Client> searchClientByAdress(Adresse adresse);
	public boolean envoyerMessage(Client cl, Contact co);

}

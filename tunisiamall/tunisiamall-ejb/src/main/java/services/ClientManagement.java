package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Adresse;
import entities.Client;
import entities.Contact;

/**
 * Session Bean implementation class ClientManagement
 */
@Stateless
@LocalBean
public class ClientManagement implements ClientManagementRemote, ClientManagementLocal {

	@PersistenceContext
	EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public ClientManagement() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean addClient(Client c) {
		
		try{
			entityManager.persist(c);
			
			return true;
		}catch(Exception e){
			System.err.println("Problem adding client ...");
		}
		return false;
		
	}

	@Override
	public boolean updateClient(Client c) {
		try {
			entityManager.merge(c);
			return true;
		} catch (Exception e) {
			System.err.println("Problem updating ...");
		}
		return false;
		
	}

	@Override
	public boolean deleteClient(Client c) {
		try {
			entityManager.remove(entityManager.merge(c));
			return true;
		} catch (Exception e) {
			System.err.println("Problem deleting ...");
		}
		return false;
	}

	@Override
	public Client searchClientByid(int id) {
		return (Client) entityManager.find(Client.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> searchClientByAdress(Adresse adresse) {
		Query query = entityManager.createQuery("SELECT ca from Client ca "
				+ " where ca.rue=:rue and ca.cp=:cp");
		query.setParameter("rue", adresse.getRue());
		query.setParameter("cp", adresse.getCp());
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> getContactsClient(Client client) {
		Query query = entityManager.createQuery("SELECT co from Client ca "
				+ " Contact co where ca.id=co.client_id");
		return query.getResultList();
	}

	@Override
	public boolean envoyerMessage(Client cl, Contact co) {
		// TODO Auto-generated method stub
		return false;
	}

}

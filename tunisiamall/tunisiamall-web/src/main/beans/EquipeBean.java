package com.esprit.beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.esprit.domain.Equipe;
import com.esprit.services.EquipeInterface;

@ManagedBean
@ApplicationScoped
public class EquipeBean {

	private String nom;
	private String logo;
	private String fondation;
	private String stade;
	private String entraineur;
	private Equipe equipeToUpdate;

	@EJB
	EquipeInterface equipeInterface;

	
	public String edit(Equipe Equipe) {
		setEquipeToUpdate(Equipe);
		return "editEquipe?faces-rediret=true";
	}

	public String updateEquipe() {
		equipeInterface.updateTeam(equipeToUpdate);
		return "listerEquipe";
	}

	public String deleteEquipe(Equipe equipe) {

		equipeInterface.deleteTeam(equipe);
		return null;
	}

	public List<Equipe> listEquipe() {

		return equipeInterface.findAllTeams();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getFondation() {
		return fondation;
	}

	public void setFondation(String fondation) {
		this.fondation = fondation;
	}

	public String getStade() {
		return stade;
	}

	public void setStade(String stade) {
		this.stade = stade;
	}

	public String getEntraineur() {
		return entraineur;
	}

	public void setEntraineur(String entraineur) {
		this.entraineur = entraineur;
	}

	public String ajouterEquipe() {
		return null;
	}

	public Equipe getEquipeToUpdate() {
		return equipeToUpdate;
	}

	public void setEquipeToUpdate(Equipe equipeToUpdate) {
		this.equipeToUpdate = equipeToUpdate;
	}

}

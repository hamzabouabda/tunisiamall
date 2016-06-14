package entities;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse {
	
	private String rue;
	private String cp;
	
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	
	
	

}

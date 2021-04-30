package fr.doranco.livretout.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fr.doranco.livretout.control.CategoryMetier;

@ManagedBean(name ="categoryBean")
public class CategoryBean implements Serializable  {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

private final CategoryMetier categoryMetier = new CategoryMetier();
	
@ManagedProperty(name="id", value="")
private Integer id;

@ManagedProperty(name="nom", value="")
private String nom;

@ManagedProperty(name="remise", value="")
private String remise;

	public CategoryBean() {
	
}
	
	public String save() {
		
		System.out.println(nom);
		System.out.println(remise);
		return "";
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getRemise() {
		return remise;
	}

	public void setRemise(String remise) {
		this.remise = remise;
	}
	
	



}

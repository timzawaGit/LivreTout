package fr.doranco.livretout.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fr.doranco.livretout.control.CategoryMetier;
import fr.doranco.livretout.dto.CategoryDto;

@ManagedBean(name ="categoryBean")
public class CategoryBean implements Serializable  {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

private final CategoryMetier categoryMetier = new CategoryMetier();
private final CategoryDto categoryDto = new CategoryDto();

	
@ManagedProperty(name="id", value="")
private Integer id;

@ManagedProperty(name="nom", value="")
private String nom;

@ManagedProperty(name="remise", value="")
private String remise;

	public CategoryBean() {
	
}
	
	public String save() {
	categoryDto.setNom(nom.trim());
	categoryDto.setRemise(remise.trim());
		try {
			categoryMetier.add(categoryDto);
			System.out.println("Ajout reussi");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("Erreur :" +e.getMessage());
		}
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

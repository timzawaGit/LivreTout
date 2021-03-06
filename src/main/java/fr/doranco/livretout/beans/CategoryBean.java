package fr.doranco.livretout.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fr.doranco.livretout.control.CategoryMetier;
import fr.doranco.livretout.dto.CategoryDto;
import fr.doranco.livretout.entity.Category;

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
	
	@ManagedProperty(name = "messageSuccess", value = "")
	private String messageSuccess;
	
	@ManagedProperty(name = "messageError", value = "")
	private String messageError;

	public CategoryBean() {
	
}
	
	public String save() {
		categoryDto.setNom(nom.trim());
		categoryDto.setRemise(remise.trim());
		try {
			categoryMetier.add(categoryDto);
			System.err.println("Ajout reussi");
			return "success-article?faces-redirect=true";
		} catch (Exception e) {
			System.err.println("Erreur :" +e.getMessage());
			messageError = "Erreur lors de l'ajout de la cat?gorie ! --> " + e.getMessage();
		}
		return "";
	}
	
	public List<Category> getCategories() {
		try {
			List<Category> categories = categoryMetier.getCategoriesAll();
			if (categories != null) {
				return categories;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erreur pour r?cup?rer la liste des cat?gories :" +e.getMessage());
		}
		return new ArrayList<Category>();
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

	public String getMessageSuccess() {
		return messageSuccess;
	}

	public void setMessageSuccess(String messageSuccess) {
		this.messageSuccess = messageSuccess;
	}

	public String getMessageError() {
		return messageError;
	}

	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}
	
	



}

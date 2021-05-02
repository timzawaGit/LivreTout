package fr.doranco.livretout.beans;

import javax.faces.bean.ManagedBean;

import fr.doranco.livretout.entity.Article;

@ManagedBean(name = "panierBean")
public class PanierBean {

	
	public PanierBean() {
	}

	public String addArticle(Article article) {
		
		return "construction?faces-redirect=true";
	}
	
}

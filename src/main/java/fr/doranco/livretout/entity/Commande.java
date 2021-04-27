package fr.doranco.livretout.entity;

import java.util.List;

public class Commande {
	
	private Integer id;
	private String dateAchat;
	private String dateLivraison;
	private Integer remiseTotalCommande;
	private Integer fraisExpedition;
	private Integer prixTotalCommande;
	private List<LigneCommande> ligneCommande;
	private User user;
	
	// dois-je mettre le nombre de ligne
	// private Integer nbLignes   ????

}

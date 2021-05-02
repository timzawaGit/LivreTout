package fr.doranco.livretout.dao;

import fr.doranco.livretout.entity.Category;
import fr.doranco.livretout.entity.LigneCommande;

public interface ILigneCommandeDao {

	LigneCommande add(LigneCommande ligneCommande) throws Exception;
}

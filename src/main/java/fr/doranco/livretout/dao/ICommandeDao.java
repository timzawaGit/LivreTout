package fr.doranco.livretout.dao;

import fr.doranco.livretout.entity.Category;
import fr.doranco.livretout.entity.Commande;

public interface ICommandeDao {

	Commande add(Commande commande) throws Exception;
}

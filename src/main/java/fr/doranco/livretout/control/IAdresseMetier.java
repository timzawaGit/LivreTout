package fr.doranco.livretout.control;

import fr.doranco.livretout.entity.Adresse;
import fr.doranco.livretout.entity.Article;

public interface IAdresseMetier {
	
	void add(Adresse adresse) throws Exception;
	Adresse getAdresse (Integer id) throws Exception;

}

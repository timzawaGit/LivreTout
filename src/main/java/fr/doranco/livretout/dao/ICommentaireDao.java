package fr.doranco.livretout.dao;

import java.util.List;

import fr.doranco.livretout.entity.Article;
import fr.doranco.livretout.entity.Commentaire;

public interface ICommentaireDao {
	
	Commentaire addCommentaire(Commentaire commentaire) throws Exception;
	Commentaire getCommentaire(Integer id) throws Exception;
	List<Commentaire> getCommentaireAll() throws Exception;
	void updateCommentaire (Commentaire commentaire)throws Exception;
	void removeCommentaire(Commentaire commentaire)throws Exception;

}

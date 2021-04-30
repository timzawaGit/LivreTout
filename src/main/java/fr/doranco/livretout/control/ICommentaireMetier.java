package fr.doranco.livretout.control;


import fr.doranco.livretout.entity.Commentaire;

public interface ICommentaireMetier {

	void add(Commentaire commentaire) throws Exception;
	Commentaire getCommentaire (Integer id) throws Exception;

}

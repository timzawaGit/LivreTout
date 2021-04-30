package fr.doranco.livretout.control;

import fr.doranco.livretout.dao.CommentaireDao;
import fr.doranco.livretout.entity.Commentaire;

public class CommentaireMetier implements ICommentaireMetier {
	
	private CommentaireDao commentaireDao = new CommentaireDao();

	@Override
	public void add(Commentaire commentaire) throws Exception {
		commentaireDao.addCommentaire(commentaire);
		
	}

	@Override
	public Commentaire getCommentaire(Integer id) throws Exception {
		
		return commentaireDao.getCommentaire(id);
	}

}

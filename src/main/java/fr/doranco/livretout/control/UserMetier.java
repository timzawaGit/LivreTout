package fr.doranco.livretout.control;

import java.util.List;

import fr.doranco.livretout.dao.IUserDao;
import fr.doranco.livretout.dao.UserDao;
import fr.doranco.livretout.entity.User;

public class UserMetier implements IUserMetier {

	private final IUserDao userDao = new UserDao();
	@Override
	public void add(User user) throws Exception {
		if (user == null) {
			throw new NullPointerException("L'utilisateur à ajouter est NULL !");
		}
		if (user.getNom() == null || user.getNom().trim().isEmpty()
				|| user.getPrenom() == null || user.getPrenom().trim().isEmpty()
				|| user.getEmail() == null || user.getEmail().trim().isEmpty()
				) {
			throw new IllegalArgumentException("Des paramètres manquent dans l'utilisateur à ajouter !");
		}
		userDao.add(user);
		
	}

	@Override
	public List<User> getAll() throws Exception {
		return userDao.getAll();
	}

}

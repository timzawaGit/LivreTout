package fr.doranco.livretout.control;

import fr.doranco.livretout.entity.Commentaire;
import fr.doranco.livretout.entity.User;

public interface IUserMetier {
	
	void add(User user) throws Exception;
	User getUser(Integer id) throws Exception;

}

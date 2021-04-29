package fr.doranco.livretout.control;

import java.util.List;

import fr.doranco.livretout.entity.User;

public interface IUserMetier {

	void add(User user) throws Exception;
	List<User> getAll() throws Exception;
}

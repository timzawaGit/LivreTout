package fr.doranco.livretout.dao;

import java.util.List;

import fr.doranco.livretout.entity.User;

public interface IUserDao {

	void add(User user) throws Exception;
	List<User> getAll() throws Exception;
	
}

package fr.doranco.livretout.dao;

import java.util.List;

import fr.doranco.livretout.entity.User;

public interface IUserDao {

	void add(User user) throws Exception;
	User getUser(Integer id)throws Exception;
	List<User> getAll() throws Exception;

	void update(User user) throws Exception;
	void remove(User user) throws Exception;
	

	User getUserByEmail(String email) throws Exception;

	
}

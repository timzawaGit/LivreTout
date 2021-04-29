package fr.doranco.livretout.control;

import java.util.List;

import fr.doranco.livretout.dto.UserDto;
import fr.doranco.livretout.entity.User;

public interface IUserMetier {

	void add(UserDto userDto) throws Exception;
	List<User> getAll() throws Exception;
	User toLogin(String email, String password) throws Exception;
}

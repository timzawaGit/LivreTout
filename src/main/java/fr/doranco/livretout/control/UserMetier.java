package fr.doranco.livretout.control;

import fr.doranco.livretout.dao.UserDao;
import fr.doranco.livretout.entity.User;

public class UserMetier implements IUserMetier {
	
	private UserDao userDao = new UserDao();

	@Override
	public void add(User user) throws Exception {
		userDao.add(user);
		
	}

	@Override
	public User getUser(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return userDao.getUser(id);
	}

}

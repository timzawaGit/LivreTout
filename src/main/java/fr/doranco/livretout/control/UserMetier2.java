package fr.doranco.livretout.control;

import fr.doranco.livretout.dao.UserDao;
import fr.doranco.livretout.entity.User;

public class UserMetier2 implements IUserMetier2 {

	private UserDao userDao = new UserDao();
	@Override
	public void add(User user) throws Exception {
		userDao.add(user);
		
	}

}

package fr.doranco.livretout.main;

import fr.doranco.livretout.dao.AdresseDao;
import fr.doranco.livretout.dao.UserDao;
import fr.doranco.livretout.entity.Adresse;
import fr.doranco.livretout.entity.User;

public class Main {

	public static void main(String[] args) {
		
		User u1 = new User();
		u1.setNom("PAN");
		u1.setPrenom("Peter");
		u1.setEmail("pan@gmail.com");

		Adresse adresse1 = new Adresse();
		adresse1.setNumero(12);
		adresse1.setRue("Eugene Masse");
		adresse1.setVille("Paris");
		adresse1.setCodePostal("75001");
		adresse1.setUser(u1);
		
		u1.getAdresses().add(adresse1);
		
		UserDao userDao = new UserDao();
		
		try {
			userDao.add(u1);
			System.out.println("User ajoute : " + u1.getId());
			System.out.println("Adresse ajoute : " + adresse1.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

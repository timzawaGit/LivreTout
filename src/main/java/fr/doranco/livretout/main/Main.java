package fr.doranco.livretout.main;

import java.sql.SQLException;

import fr.doranco.livretout.control.ArticleMetier;
import fr.doranco.livretout.dao.AdresseDao;
import fr.doranco.livretout.dao.ArticleDao;
import fr.doranco.livretout.entity.Adresse;
import fr.doranco.livretout.entity.Article;
import fr.doranco.livretout.entity.User;

public class Main {
	
	private static AdresseDao adresseDao = new AdresseDao();

	public static void main(String[] args) {
		
		
		User user = new User("PAN", "Peter", "pan@gmail.com");
		
		Adresse adresse1 = new Adresse();
		
		adresse1.setNumero(12);
		adresse1.setRue("rue de paris");
		adresse1.setVille("Paris");
		adresse1.setCodePostal("75006");
		adresse1.setUser(user);
		
		user.getAdresses().add(adresse1);
		
		try {
			adresseDao.add(adresse1);
			System.out.println("id adresse ajoute : " + adresse1.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}

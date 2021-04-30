package fr.doranco.livretout.control;

import fr.doranco.livretout.dao.AdresseDao;
import fr.doranco.livretout.dao.ArticleDao;
import fr.doranco.livretout.entity.Adresse;

public class AdresseMetier implements IAdresseMetier {
	
	private AdresseDao adresseDao = new AdresseDao();

	@Override
	public void add(Adresse adresse) throws Exception {
		
		adresseDao.add(adresse);
	}

	@Override
	public Adresse getAdresse(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return adresseDao.getAdresse(id);
	}



}

package fr.doranco.livretout.control;

import java.util.Date;

import javax.crypto.SecretKey;

import fr.doranco.livretout.control.cryptage.algo.CryptageDES;
import fr.doranco.livretout.control.cryptage.keys.GenerateKey;
import fr.doranco.livretout.dao.CartePaiementDao;
import fr.doranco.livretout.dao.ICartePaiementDao;
import fr.doranco.livretout.dao.IUserDao;
import fr.doranco.livretout.dao.UserDao;
import fr.doranco.livretout.dto.CartePaiementDto;
import fr.doranco.livretout.entity.CartePaiement;
import fr.doranco.livretout.entity.User;
import fr.doranco.livretout.enums.AlgoCryptage;

public class CartePaiementMetier implements ICartePaiementMetier {

	
	// plus tard je poserai la question : eske je pourrai mettre le type CartePaiementDao au lieu de ICartePaiementDao
	private ICartePaiementDao cartePaiementDao = new CartePaiementDao();
	private IUserDao userDao = new UserDao();

	@Override
	public void add(CartePaiementDto cartePaiementDto) throws Exception {
		
		if(cartePaiementDto==null) {
			throw new NullPointerException("La carte à ajouter est NULL !");
		}
		
		if(cartePaiementDto.getNomProprietaire()==null || cartePaiementDto.getNomProprietaire().trim().isEmpty()
		|| cartePaiementDto.getPrenomProprietaire()==null || cartePaiementDto.getPrenomProprietaire().trim().isEmpty()
		|| cartePaiementDto.getNumero()== null || cartePaiementDto.getNumero().trim().isEmpty()
		|| cartePaiementDto.getDateLimite()==null|| cartePaiementDto.getDateLimite().trim().isEmpty()
		|| cartePaiementDto.getCryptogramme()==null || cartePaiementDto.getCryptogramme().trim().isEmpty()
		) {
	
		throw new IllegalArgumentException("Des paramètres de type string manquent dans la carte à ajouter !");
		}
		CartePaiement cartePaiement = new CartePaiement();
		cartePaiement.setNomProprietaire(cartePaiementDto.getNomProprietaire());
		cartePaiement.setPrenomProprietaire(cartePaiementDto.getPrenomProprietaire());
        cartePaiement.setDateLimite(cartePaiementDto.getDateLimite());
		
		
		// Les parametres avec cryptage
			SecretKey secretKey = GenerateKey.getKey(AlgoCryptage.DES.toString(), 56);
			cartePaiement.setCleCryptage(secretKey.getEncoded());
			cartePaiement.setNumero(CryptageDES.encrypt(cartePaiementDto.getNumero(), secretKey));
			cartePaiement.setCryptogramme(CryptageDES.encrypt(cartePaiementDto.getCryptogramme(), secretKey));

		
			// Pour le test on donne un user pour la carte
			
			String message="blabla";
			User user = new User();
			user.setNom("toto");
			user.setPrenom("gaga");
			user.setEmail("tg@hh.fr");
			user.setCleCryptage(secretKey.getEncoded());
			user.setPassword(CryptageDES.encrypt(message, secretKey));
			userDao.add(user); 
		
			cartePaiement.setUserCarte(user);
			cartePaiementDao.add(cartePaiement);
		
	}
	
}



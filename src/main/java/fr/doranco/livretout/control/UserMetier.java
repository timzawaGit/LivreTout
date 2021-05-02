package fr.doranco.livretout.control;

import java.util.List;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import fr.doranco.livretout.control.cryptage.algo.CryptageDES;
import fr.doranco.livretout.control.cryptage.keys.GenerateKey;
import fr.doranco.livretout.dao.IUserDao;
import fr.doranco.livretout.dao.UserDao;
import fr.doranco.livretout.dto.AdresseDto;
import fr.doranco.livretout.dto.CartePaiementDto;
import fr.doranco.livretout.dto.UserDto;
import fr.doranco.livretout.entity.Adresse;
import fr.doranco.livretout.entity.CartePaiement;
import fr.doranco.livretout.entity.User;
import fr.doranco.livretout.enums.AlgoCryptage;

public class UserMetier implements IUserMetier {

	private final IUserDao userDao = new UserDao();
	@Override
	public void add(UserDto userDto) throws Exception {
		if (userDto == null) {
			throw new NullPointerException("L'utilisateur à ajouter est NULL !");
		}
		if (userDto.getNom() == null || userDto.getNom().trim().isEmpty()
				|| userDto.getPrenom() == null || userDto.getPrenom().trim().isEmpty()
				|| userDto.getEmail() == null || userDto.getEmail().trim().isEmpty()
				|| userDto.getPassword() == null || userDto.getPassword().trim().isEmpty()
				) {
			throw new IllegalArgumentException("Des paramètres manquent dans l'utilisateur à ajouter !");
		}
		
		// Set non formatting data
		User user = new User();
		user.setNom(userDto.getNom().trim());
		user.setPrenom(userDto.getPrenom().trim());
		user.setEmail(userDto.getEmail().trim());
		
		// Set formatting data
		SecretKey secretKey = GenerateKey.getKey(AlgoCryptage.DES.toString(), 56);
		user.setCleCryptage(secretKey.getEncoded());
		user.setPassword(CryptageDES.encrypt(userDto.getPassword(), secretKey));
		
		// Set adresses
		if (userDto.getAdresses() != null && !userDto.getAdresses().isEmpty()) {
			for (AdresseDto adressDto : userDto.getAdresses()) {
				Adresse adresse = new Adresse();
				adresse.setNumero(adressDto.getNumero());
				adresse.setRue(adressDto.getRue().trim());
				adresse.setVille(adressDto.getVille().trim());
				adresse.setCodePostal(adressDto.getCodePostal().trim());
				adresse.setUser(user);
				user.getAdresses().add(adresse);
			}
		}
		
		// set carte paiement
		
		if(userDto.getCartes()!=null && !userDto.getCartes().isEmpty()) {
			for(CartePaiementDto cartePaiementDto : userDto.getCartes()) {
				CartePaiement cartePaiement = new CartePaiement();
				cartePaiement.setNomProprietaire(cartePaiementDto.getNomProprietaire());
				cartePaiement.setPrenomProprietaire(cartePaiementDto.getPrenomProprietaire());
				cartePaiement.setDateLimite(cartePaiementDto.getDateLimite());
				
				
				cartePaiement.setNumero(CryptageDES.encrypt(cartePaiementDto.getNumero(), secretKey));
				cartePaiement.setCryptogramme(CryptageDES.encrypt(cartePaiementDto.getCryptogramme(), secretKey));
				cartePaiement.setCleCryptage(secretKey.getEncoded());
				cartePaiement.setUser(user);
				user.getCartes().add(cartePaiement);
			}
		}
		
		userDao.add(user);
		
	}

	@Override
	public List<User> getAll() throws Exception {
		return userDao.getAll();
	}

	@Override
	public User toLogin(String email, String password) throws Exception {
		if (email == null || email.trim().isEmpty() 
				|| password == null || password.trim().isEmpty()) {
			throw new IllegalArgumentException("Des paramètres manquent pour se connecter !");
		}
		
		User user = userDao.getUserByEmail(email.trim());
		
		if (user != null) {
			// Decode password
			SecretKeySpec skey = new SecretKeySpec(user.getCleCryptage(), AlgoCryptage.DES.toString());
			String passwordDecoded = CryptageDES.decrypt(user.getPassword(), skey);
			
			if (passwordDecoded.equals(password.trim())) {
				return user;
			}
		}
		
		return null;
	}

}

package fr.doranco.livretout.control;

import java.util.List;

import javax.crypto.SecretKey;

import fr.doranco.livretout.control.cryptage.algo.CryptageDES;
import fr.doranco.livretout.control.cryptage.keys.GenerateKey;
import fr.doranco.livretout.dao.IUserDao;
import fr.doranco.livretout.dao.UserDao;
import fr.doranco.livretout.dto.AdresseDto;
import fr.doranco.livretout.dto.UserDto;
import fr.doranco.livretout.entity.Adresse;
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
		user.setNom(userDto.getNom());
		user.setPrenom(userDto.getPrenom());
		user.setEmail(userDto.getEmail());
		
		// Set formatting data
		SecretKey secretKey = GenerateKey.getKey(AlgoCryptage.DES.toString(), 56);
		user.setCleCryptage(secretKey.getEncoded());
		user.setPassword(CryptageDES.encrypt(userDto.getPassword(), secretKey));
		
		// Set adresses
		if (userDto.getAdresses() != null && !userDto.getAdresses().isEmpty()) {
			for (AdresseDto adressDto : userDto.getAdresses()) {
				Adresse adresse = new Adresse();
				adresse.setNumero(adressDto.getNumero());
				adresse.setRue(adressDto.getRue());
				adresse.setVille(adressDto.getVille());
				adresse.setCodePostal(adressDto.getCodePostal());
				adresse.setUser(user);
				user.getAdresses().add(adresse);
			}
		}
		
		userDao.add(user);
		
	}

	@Override
	public List<User> getAll() throws Exception {
		return userDao.getAll();
	}

}

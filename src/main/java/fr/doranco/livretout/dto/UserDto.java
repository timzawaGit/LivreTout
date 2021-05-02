package fr.doranco.livretout.dto;

import java.util.ArrayList;
import java.util.List;

public class UserDto {

	private Integer id;
	private String nom;
	private String prenom;
	private String email;
	private String password;
	private List<AdresseDto> adresses;
	private List<CartePaiementDto> cartes;
	
	public UserDto() {
		adresses = new ArrayList<AdresseDto>();
		cartes = new ArrayList<CartePaiementDto>();
	}

	public UserDto(String nom, String prenom, String email, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		adresses = new ArrayList<AdresseDto>();
		cartes = new ArrayList<CartePaiementDto>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<AdresseDto> getAdresses() {
		return adresses;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", password="
				+ password + ", adresses=" + adresses + "]";
	}

	public List<CartePaiementDto> getCartes() {
		return cartes;
	}

	
	
	
	
	
	
}

package fr.doranco.livretout.beans;



import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fr.doranco.livretout.control.CartePaiementMetier;
import fr.doranco.livretout.control.ICartePaiementMetier;
import fr.doranco.livretout.dto.CartePaiementDto;
import fr.doranco.livretout.entity.CartePaiement;

@ManagedBean(name ="cartePaiementBean")
public class CartePaiementBean implements Serializable {


		
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
		private final ICartePaiementMetier cartePaiementMetier = new CartePaiementMetier();
		private final CartePaiementDto cartePaiementDto = new CartePaiementDto();
		
		// il faut faire attention au nom des attributs pas de camel case genre: camelCase (pas de majuscule) sinon ca fout la merde
		
		@ManagedProperty(name="id", value="")
		private int id;
		
		
		@ManagedProperty(name="nomproprietaire", value="")
		private String nomproprietaire;
		
		
		@ManagedProperty(name="prenomproprietaire", value="")
		private String prenomproprietaire;
		
		@ManagedProperty(name="numero", value="")
		private String numero;
		
		
		@ManagedProperty(name="datelimite", value="")
		private String datelimite;
		
		
		@ManagedProperty(name="cryptogramme", value="")
		private String cryptogramme;
		
		
		@ManagedProperty(name="clecryptage", value="")
		private String clecryptage;
		
//		@ManagedProperty(name="usercarte", value="")
//		private String usercarte;
		
		public CartePaiementBean() {
			
		}

		
		
		    public String save() {
		    cartePaiementDto.setNomProprietaire(nomproprietaire.trim());
		    cartePaiementDto.setPrenomProprietaire(prenomproprietaire.trim());
		    cartePaiementDto.setNumero(numero.trim());
		    cartePaiementDto.setDateLimite(datelimite.trim());
		    cartePaiementDto.setCryptogramme(cryptogramme.trim());
		    //cartePaiementDto.setCleCryptage(clecryptage.trim());
		    //cartePaiementDto.setUserCarte(usercarte.trim()));
		    System.out.println("on a passe les argument" +cartePaiementDto.getNomProprietaire());
		    
		    
		    try {
		    	cartePaiementMetier.add(cartePaiementDto);
				System.out.println("ajout de carte reussi");
			} catch (Exception e) {
			
				e.printStackTrace();
				System.out.println("Erreur :" +e.getMessage());
			}
		    return "";
		    }



			public int getId() {
				return id;
			}



			public void setId(int id) {
				this.id = id;
			}



			



			public String getNomproprietaire() {
				return nomproprietaire;
			}



			public void setNomproprietaire(String nomproprietaire) {
				this.nomproprietaire = nomproprietaire;
			}





			public String getPrenomproprietaire() {
				return prenomproprietaire;
			}



			public void setPrenomproprietaire(String prenomproprietaire) {
				this.prenomproprietaire = prenomproprietaire;
			}



			public String getNumero() {
				return numero;
			}



			public void setNumero(String numero) {
				this.numero = numero;
			}


		



			public String getDatelimite() {
				return datelimite;
			}



			public void setDatelimite(String datelimite) {
				this.datelimite = datelimite;
			}



			public String getCryptogramme() {
				return cryptogramme;
			}



			public void setCryptogramme(String cryptogramme) {
				this.cryptogramme = cryptogramme;
			}



		



			public String getClecryptage() {
				return clecryptage;
			}



			public void setClecryptage(String clecryptage) {
				this.clecryptage = clecryptage;
			}



//			public String getUsercarte() {
//				return usercarte;
//			}
//
//
//
//			public void setUsercarte(String usercarte) {
//				this.usercarte = usercarte;
//			}



		



			

		
		
	}
		


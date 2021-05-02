package fr.doranco.livretout.control;

import fr.doranco.livretout.dto.CartePaiementDto;
import fr.doranco.livretout.entity.CartePaiement;

public interface ICartePaiementMetier {
	
	void add (CartePaiementDto cartePaiementDto) throws Exception;

}

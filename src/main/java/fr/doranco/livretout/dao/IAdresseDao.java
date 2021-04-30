package fr.doranco.livretout.dao;

import java.util.List;

import fr.doranco.livretout.entity.Adresse;
import fr.doranco.livretout.entity.User;

public interface IAdresseDao {
	void add(Adresse adresse) throws Exception;
	Adresse getAdresse(Integer id)throws Exception;
	List<Adresse> getAll() throws Exception;
	void update(Adresse adresse) throws Exception;
	void remove(Adresse adresse) throws Exception;
}

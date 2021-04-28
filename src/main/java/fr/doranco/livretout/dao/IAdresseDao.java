package fr.doranco.livretout.dao;

import java.util.List;

import fr.doranco.livretout.entity.Adresse;

public interface IAdresseDao {
	void add(Adresse adresse) throws Exception;
	List<Adresse> getAll() throws Exception;
}

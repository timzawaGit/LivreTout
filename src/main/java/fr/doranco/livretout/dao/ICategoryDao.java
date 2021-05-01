package fr.doranco.livretout.dao;

import java.sql.SQLException;
import java.util.List;

import fr.doranco.livretout.entity.Category;

public interface ICategoryDao {
	
	//CRUD
	
	Category addCategory(Category category) throws Exception;
	Category getCategory (Integer id) throws Exception;
	// ou bien afficher la liste des article
	List<Category> getCategoryAll() throws Exception;
	
	//
	void updateCategory (Category category)throws Exception;
	//void removeCategory(Integer id)throws Exception;
	// je fais la mehode remove avec Category comme parametre car avec le id, je ne suis pas sur
	void removeCategory(Category category)throws Exception;
	
	Category getByName(String nomCategory) throws Exception;

}

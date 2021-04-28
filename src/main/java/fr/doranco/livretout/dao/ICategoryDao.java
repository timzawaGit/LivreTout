package fr.doranco.livretout.dao;

import java.sql.SQLException;
import java.util.List;

import fr.doranco.livretout.entity.Category;

public interface ICategoryDao {
	
	//CRUD
	
	Category addCategory(Category category) throws SQLException;
	Category getArticles (Integer id) throws SQLException;
	// ou bien afficher la liste des article
	List<Category> getCategoryAll() throws SQLException;
	void updateCategory (Integer id)throws SQLException;
	void removeCategory(Integer id)throws SQLException;

}

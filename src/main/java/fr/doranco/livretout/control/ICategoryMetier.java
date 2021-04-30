package fr.doranco.livretout.control;

import java.util.List;

import fr.doranco.livretout.beans.CategoryBean;
import fr.doranco.livretout.dto.CategoryDto;
import fr.doranco.livretout.entity.Category;

public interface ICategoryMetier {
	
	//CRUD
	
	Category addCategory(Category category) throws Exception;
	Category getCategory (Integer id) throws Exception;

	List<Category> getCategoriesAll() throws Exception;
	void updateCategory (Category category)throws Exception;
	void removeCategory(Category category)throws Exception;
	
	void add(CategoryDto categoryDto) throws Exception;
}

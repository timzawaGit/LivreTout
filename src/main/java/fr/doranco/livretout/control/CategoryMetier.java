package fr.doranco.livretout.control;

import java.util.List;

import fr.doranco.livretout.beans.CategoryBean;
import fr.doranco.livretout.dao.ArticleDao;
import fr.doranco.livretout.dao.CategoryDao;
import fr.doranco.livretout.dto.CategoryDto;
import fr.doranco.livretout.entity.Category;

public class CategoryMetier implements ICategoryMetier {
	
	private CategoryDao categoryDao = new CategoryDao();

	@Override
	public Category addCategory(Category category) throws Exception {
		// TODO Auto-generated method stub
		return categoryDao.addCategory(category);
	}




	@Override
	public List<Category> getCategoriesAll() throws Exception {
		return categoryDao.getCategoryAll();
	}




	@Override
	public Category getCategory(Integer id) throws Exception {
		
		return categoryDao.getCategory(id);
	}




	@Override
	public void updateCategory(Category category) throws Exception {
		categoryDao.updateCategory(category);
		
	}




	@Override
	public void removeCategory(Category category) throws Exception {
		categoryDao.removeCategory(category);
		
	}




	@Override
	public void add(CategoryDto categoryDto) throws Exception {
		if(categoryDto==null) {
			throw new NullPointerException("La categorie à ajouter est NULL !");
		}
		if(categoryDto.getNom()==null ||categoryDto.getNom().trim().isEmpty() )
			throw new IllegalArgumentException("Des paramètres manquent dans la categorie à ajouter !");
		
		Category category = new Category();
		category.setNomCategory(categoryDto.getNom());
		
		if(categoryDto.getRemise()==null || categoryDto.getRemise().trim().isEmpty() ) {
			category.setRemise(0);
		} else {
			category.setRemise(Integer.parseInt(categoryDto.getRemise()));;
		}
			
			categoryDao.addCategory(category);
	}




	@Override
	public Category getByName(String nomCategory) throws Exception {
		if(nomCategory == null) {
			throw new NullPointerException("Le nom de la categorie à récupérer est NULL !");
		}
		if(nomCategory == null || nomCategory.trim().isEmpty() )
			throw new IllegalArgumentException("Le nom de la catégorie n'est pas un String ou Manquant !");
		
		return categoryDao.getByName(nomCategory.trim());
	}




	

	

}

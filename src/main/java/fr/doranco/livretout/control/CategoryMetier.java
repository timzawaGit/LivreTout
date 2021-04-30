package fr.doranco.livretout.control;

import java.util.List;

import fr.doranco.livretout.dao.ArticleDao;
import fr.doranco.livretout.dao.CategoryDao;
import fr.doranco.livretout.entity.Category;

public class CategoryMetier implements ICategoryMetier {
	
	private CategoryDao categoryDao = new CategoryDao();

	@Override
	public Category addCategory(Category article) throws Exception {
		// TODO Auto-generated method stub
		return categoryDao.addCategory(article);
	}




	@Override
	public List<Category> getCategoriesAll() throws Exception {
		// TODO Auto-generated method stub
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


	

}

package fr.doranco.livretout.main;

import java.sql.SQLException;
import java.util.List;

import fr.doranco.livretout.control.AdresseMetier;
import fr.doranco.livretout.control.ArticleMetier;
import fr.doranco.livretout.control.CategoryMetier;
import fr.doranco.livretout.control.CommentaireMetier;
import fr.doranco.livretout.control.UserMetier;
import fr.doranco.livretout.dao.AdresseDao;
import fr.doranco.livretout.dao.ArticleDao;
import fr.doranco.livretout.dao.CategoryDao;
import fr.doranco.livretout.dao.CommentaireDao;
import fr.doranco.livretout.dao.UserDao;
import fr.doranco.livretout.entity.Adresse;
import fr.doranco.livretout.entity.Article;
import fr.doranco.livretout.entity.Category;
import fr.doranco.livretout.entity.Commentaire;
import fr.doranco.livretout.entity.User;

public class Main {
	
	private static final ArticleMetier articleMetier = new ArticleMetier();
	private static final ArticleDao articleDao = new ArticleDao();
	
	private static final CategoryMetier categoryMetier = new CategoryMetier();
	private static final CategoryDao categoryDao = new CategoryDao();
	
	private static final UserMetier userMetier = new UserMetier();
	private static final UserDao userDao = new UserDao();
	
	private static final AdresseMetier adresseMetier = new AdresseMetier();
	private static final AdresseDao adresseDao = new AdresseDao();
	
	private static final CommentaireMetier commentaireMetier = new CommentaireMetier();
	private static final CommentaireDao commentaireDao = new CommentaireDao();

	public static void main(String[] args) {
		
		// c'est ce qu'il y aura sur le bean
		
	
//// CREATION NUMBER 1
//		
//		Category category = new Category();
//		category.setNomCategory("fruits");
//		category.setRemise(10);
//		//category.setArticle(article);
//		
//		Article article = new Article();
//		article.setIntitule("mirtille");
//		article.setPrix(2);
//		article.setDescription("des fruits bio venant des montagne du caucase");
//		article.setRemise(10);
//		article.setQuantite(1);
//		article.setCategory(category);
//		// il faut absolument call la DAO pour la base, ne pas faire comme ci-dessus
//		// c hibernate qui rajoute un article (car on ajoute un article a une categorie donc il sousentend qu'il y a un autre article)
//		//category.getArticles().add(article);
//		
//		User user1 = new User();
//		user1.setNom("paul");
//		user1.setPrenom("jean");
//		user1.setEmail("jp@gmail.com");
//	
//	
//		
//		Adresse adresse1 = new Adresse();
//		adresse1.setNumero(1);
//		adresse1.setRue("rue bidul");
//		adresse1.setCodePostal("75000");
//		adresse1.setVille("Paris");
//		adresse1.setUser(user1);
//		user1.getAdresses().add(adresse1);
//		
//		Commentaire commentaire =new Commentaire();
//		commentaire.setNote(4.00f);
//		commentaire.setTexte("pas trop mal");
//		commentaire.setArticle(article);
//		commentaire.setUser(user1);
//		
//		
//		// CREATION NUMBER 2
//		
//				Category category2 = new Category();
//				category2.setNomCategory("legumes");
//				category2.setRemise(5);
//				//category.setArticle(article);
//				
//				Article article2 = new Article();
//				article2.setIntitule("courgette");
//				article2.setPrix(2);
//				article2.setDescription("des legumes bio IDF");
//				article2.setRemise(2);
//				article2.setQuantite(3);
//				article2.setCategory(category2);
				// il faut absolument call la DAO pour la base, ne pas faire comme ci-dessus
				// c hibernate qui rajoute un article (car on ajoute un article a une categorie donc il sousentend qu'il y a un autre article)
				//category.getArticles().add(article);
//				
//				User user2 = new User();
//				user2.setNom("claude");
//				user2.setPrenom("francois");
//				user2.setEmail("cf@gmail.com");
//				user2.setId(2);
////			
////			
////				
//				Adresse adresse2 = new Adresse();
//				adresse2.setNumero(22);
//				adresse2.setRue("rue chouette");
//				adresse2.setCodePostal("69000");
//				adresse2.setVille("Lyon");
//				adresse2.setUser(user2);
//				user2.getAdresses().add(adresse2);
//				
//				Commentaire commentaire2 =new Commentaire();
//				commentaire2.setNote(3.00f);
//				commentaire2.setTexte("pas de gout");
//				commentaire2.setArticle(article2);
//				commentaire2.setUser(user2);

				
				
				
				
				// CREATION NUMBER 3
//				
//						Category category3 = new Category();
//						category3.setNomCategory("sucrerie");
//						category3.setRemise(2);
//						//category.setArticle(article);
//						
//						Article article3 = new Article();
//						article3.setIntitule("caramel");
//						article3.setPrix(5);
//						article3.setDescription("caramel sale");
//						article3.setRemise(2);
//						article3.setQuantite(3);
//						article3.setCategory(category3);
//						// il faut absolument call la DAO pour la base, ne pas faire comme ci-dessus
//						// c hibernate qui rajoute un article (car on ajoute un article a une categorie donc il sousentend qu'il y a un autre article)
//						//category.getArticles().add(article);
////						
//						User user3 = new User();
//						user3.setNom("bill");
//						user3.setPrenom("clinton");
//						user3.setEmail("bc@gmail.com");
//					//	user3.setId(2);
////					
////					
////						
//						Adresse adresse3 = new Adresse();
//						adresse3.setNumero(22);
//						adresse3.setRue("rue truc");
//						adresse3.setCodePostal("12000");
//						adresse3.setVille("Marseille");
//						adresse3.setUser(user3);
//						user3.getAdresses().add(adresse3);
//						
//						Commentaire commentaire3 =new Commentaire();
//						commentaire3.setNote(3.00f);
//						commentaire3.setTexte("tres sucre");
//						commentaire3.setArticle(article3);
//						commentaire3.setUser(user3);
				
//	-------------------------------------------------------------------------------------------------------------
		
//				// AJout du number 1
//		
//		try {
//			categoryDao.addCategory(category);
//			System.out.println("categorie ajoutee: " + category.getId());
//			articleDao.addArticle(article);
//			System.out.println("article ajoute: " + article.getId());
//			userDao.add(user1);
//			System.out.println("user ajoute: " + user1.getId());
//////			adresseDao.add(adresse1);
//////			System.out.println("adresse ajoute: " + adresse1.getId());
//			commentaireDao.addCommentaire(commentaire);
//			System.out.println("commentaire ajoute: " + commentaire.getId());
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	-------------------------------------------------------------------------------------------------------------	
//				// AJout du number 2
//				
//				try {
//					categoryDao.addCategory(category2);
//					System.out.println("categorie ajoutee: " + category2.getId());
//					articleDao.addArticle(article2);
//					System.out.println("article ajoute: " + article2.getId());
//					userDao.add(uadresse3;
//					System.out.println("user ajoute: " + user2.getId());
////					adresseDao.add(adresse1);
////					System.out.println("adresse ajoute: " + adresse1.getId());
//					commentaireDao.addCommentaire(commentaire2);
//					System.out.println("commentaire ajoute: " + commentaire2.getId());
//					
//				} catch (Exception e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}	
		
//	-------------------------------------------------------------------------------------------------------------
			
						
						// AJout du number 3 via Metier
//						
//						try {
//							categoryMetier.addCategory(category3);
//							System.out.println("categorie ajoutee: " + category3.getId());
//							articleMetier.addArticle(article3);
//							System.out.println("article ajoute: " + article3.getId());
//							userMetier.add(user3);
//							System.out.println("user ajoute: " + user3.getId());
//////							adresseDao.add(adresse1);
//////							System.out.println("adresse ajoute: " + adresse1.getId());
//							commentaireMetier.add(commentaire3);
//							System.out.println("commentaire ajoute: " + commentaire3.getId());
//							
//						} catch (Exception e) {
//							
//							e.printStackTrace();
//						}	
//				
						
						
						
						
			// Test des methodes get	
				
		
//		
		try {
			List<Article> articles;
				articles = articleMetier.getArticlesAll();
				System.out.println("la liste des articles: " + articles);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		
		
		
//		try {
//			List<Category> categories;
//				categories = categoryDao.getCategoryAll();
//				System.out.println("la liste des categories: " + categories);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		
//		try {
//			List<Commentaire> commentaires;
//			commentaires = commentaireDao.getCommentaireAll();
//				System.out.println("la liste des categories: " + commentaires);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		
//		try {
//			List<Adresse> adresses;
//			adresses = adresseDao.getAll();
//				System.out.println("la liste des categories: " + adresses);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		
//		try {
//			List<User> users;
//			users = userDao.getAll();
//				System.out.println("la liste des categories: " + users);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		
	//	-------------------------------------------------------------------------------------------------------------
		
		// test des methodes update et remove
		
//	try {
//		userDao.remove(user2);
//		System.out.println("cet user a ete efface : "+ user2);
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//


	}
	


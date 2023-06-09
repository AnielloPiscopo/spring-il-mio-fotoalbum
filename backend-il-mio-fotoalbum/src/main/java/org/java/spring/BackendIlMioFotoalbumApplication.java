package org.java.spring;

import java.util.ArrayList;
import java.util.List;

import org.java.spring.auth.pojo.Role;
import org.java.spring.auth.pojo.User;
import org.java.spring.auth.services.RoleServ;
import org.java.spring.auth.services.UserServ;
import org.java.spring.helper.Helper;
import org.java.spring.pojo.Category;
import org.java.spring.pojo.Photo;
import org.java.spring.services.CategoryServ;
import org.java.spring.services.PhotoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.github.javafaker.Faker;

@SpringBootApplication
public class BackendIlMioFotoalbumApplication implements CommandLineRunner {
	
	@Autowired
	private UserServ userServ;
	
	@Autowired
	private RoleServ roleServ;
	
	@Autowired
	private PhotoServ photoServ;
	
	@Autowired
	private CategoryServ categoryServ;
	
	private static List<Category> categoriesList = new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(BackendIlMioFotoalbumApplication.class, args);
	}
	
	public void run(String... args) throws Exception{
		addToDb();
	}
	
	private void createUsersAndRoles(){
		Role roleAdmin = new Role("ADMIN");
		
		roleServ.save(roleAdmin);
		
		final String pws = new BCryptPasswordEncoder().encode("pws");
		
		User userAdmin = new User("admin", pws, roleAdmin);
				
		userServ.save(userAdmin);
	}
	
	private void addToDb() {
		Faker f = new Faker();
		
		createUsersAndRoles();
		
		createCategoriesList(f).stream().forEach(c -> categoryServ.save(c));
		
		createPhotosList(f, categoriesList).stream().forEach(p -> photoServ.save(p));
	}
	
	private List<Category> createCategoriesList(Faker f){
		int categoriesNum = Helper.createRndNumberInRangeWithFaker(10, 50, f);
		
		for(int i=1 ; i<categoriesNum ; i++) {
			String name = String.join(", " , f.lorem().words());
			Category c = new Category(name);
			categoriesList.add(c);
		}
		
		return categoriesList;
	}
	
	private List<Photo> createPhotosList(Faker f , List<Category> categories) {
		List<Photo> photosList = new ArrayList<>();
		int cSize = categories.size();
		int photosNum = Helper.createRndNumberInRangeWithFaker(10, 100, f);
		
		for(int i=1 ; i<photosNum ; i++) {
			String title = String.join(", " , f.lorem().words());
			String description = f.lorem().sentence(10);
			String imgUrl = f.internet().image();
			boolean visible = true;
			int rndCIndex = Helper.createRndNumberInRangeWithFaker(0, cSize, f);
			Category selectedCategory = categories.get(rndCIndex);
			Photo p = new Photo(title,description,imgUrl,visible ,selectedCategory);
			photosList.add(p);
		}
		
		return photosList;
	}

}

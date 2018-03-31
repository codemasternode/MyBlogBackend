package com.awareness.ApiWithJWT;


import com.awareness.ApiWithJWT.model.RoleName;
import com.awareness.ApiWithJWT.model.User;
import com.awareness.ApiWithJWT.model.UserRole;
import com.awareness.ApiWithJWT.model.blog.BlogCategory;
import com.awareness.ApiWithJWT.model.blog.BlogComment;
import com.awareness.ApiWithJWT.model.blog.BlogPost;
import com.awareness.ApiWithJWT.model.tutorial.Tutorial;
import com.awareness.ApiWithJWT.model.tutorial.TutorialCategory;
import com.awareness.ApiWithJWT.model.tutorial.TutorialComment;
import com.awareness.ApiWithJWT.repositories.UserRoleRepo;
import com.awareness.ApiWithJWT.repositories.blog.BlogCategoryRepo;
import com.awareness.ApiWithJWT.repositories.blog.BlogCommentRepo;
import com.awareness.ApiWithJWT.repositories.blog.BlogPostRepo;
import com.awareness.ApiWithJWT.repositories.tutorial.TutorialCategoryRepo;
import com.awareness.ApiWithJWT.repositories.tutorial.TutorialCommentRepo;
import com.awareness.ApiWithJWT.repositories.tutorial.TutorialRepo;
import com.awareness.ApiWithJWT.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;



import javax.annotation.PostConstruct;

import java.time.LocalDateTime;
import java.util.*;

@SpringBootApplication
@EntityScan(
		basePackageClasses = {
				ApiWithJwtApplication.class,
				Jsr310JpaConverters.class
		}
)
public class ApiWithJwtApplication implements CommandLineRunner{

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private TutorialRepo tutorialRepo;

	@Autowired
	private TutorialCategoryRepo tutorialCategoryRepo;

	@Autowired
	private BlogCategoryRepo blogCategoryRepo;

	@Autowired
	private BlogPostRepo blogPostRepo;


	@Autowired
	private UserRoleRepo userRoleRepo;

	@Autowired
	private BlogCommentRepo blogCommentRepo;

	@Autowired
	private TutorialCommentRepo tutorialCommentRepo;

	public static void main(String[] args) {
		SpringApplication.run(ApiWithJwtApplication.class, args);
	}

	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	@Override
	public void run(String... args) throws Exception {
		/*Set<UserRole> roleSet = new HashSet<>();
		roleSet.add(new UserRole(Role.ADMIN_ROLE));
		User user = new User("Marcin","Warzybok","email@em.com","1231231231",roleSet,true);
		System.out.println("------------------------------------------------------------------------");
		System.out.println(LocalDateTime.now().plusHours(2));
		System.out.println("------------------------------------------------------------------------");
		userRepo.save(user);
		TutorialCategory tutorialCategory = new TutorialCategory("Java");
		tutorialCategoryRepo.save(tutorialCategory);
		Tutorial tutorial = new Tutorial("Java co dalej??","http://obrazek.jpg","To jest zawartość tutoriala",tutorialCategory);
		tutorialRepo.save(tutorial);
		BlogCategory blogCategory = new BlogCategory("Branża IT");
		blogCategoryRepo.save(blogCategory);
		BlogPost blogPost = new BlogPost("Jak zarabiać w IT","http://bog2.png","Zarabianie w IT jest bardzo trudne",blogCategory);
		blogPostRepo.save(blogPost);

		List<Tutorial> tutorialList = tutorialRepo.findAll();
		for(Tutorial t:tutorialList){
			System.out.println(t.getTitle() + "to jest tytuł");
		}*/
		//Optional<UserRole> userRole = userRoleRepo.findByRole(RoleName.ROLE_USER);
	}
}

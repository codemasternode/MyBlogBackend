package com.awareness.ApiWithJWT;



import com.awareness.ApiWithJWT.model.tutorial.Tutorial;
import com.awareness.ApiWithJWT.model.tutorial.TutorialCategory;
import com.awareness.ApiWithJWT.repositories.RoleRepository;
import com.awareness.ApiWithJWT.repositories.UserRepository;

import com.awareness.ApiWithJWT.repositories.blog.BlogCategoryRepo;
import com.awareness.ApiWithJWT.repositories.blog.BlogCommentRepo;
import com.awareness.ApiWithJWT.repositories.blog.BlogPostRepo;
import com.awareness.ApiWithJWT.repositories.tutorial.TutorialCategoryRepo;
import com.awareness.ApiWithJWT.repositories.tutorial.TutorialCommentRepo;
import com.awareness.ApiWithJWT.repositories.tutorial.TutorialRepo;

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
	private UserRepository userRepo;

	@Autowired
	private TutorialRepo tutorialRepo;

	@Autowired
	private TutorialCategoryRepo tutorialCategoryRepo;

	@Autowired
	private BlogCategoryRepo blogCategoryRepo;

	@Autowired
	private BlogPostRepo blogPostRepo;


	@Autowired
	private RoleRepository userRoleRepo;

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
		/*
		TutorialCategory tutorialCategory = new TutorialCategory("Java");
		tutorialCategoryRepo.save(tutorialCategory);
		Tutorial tutorial = new Tutorial("Java, i co dalej?",
				"https://ocs-pl.oktawave.com/v1/AUTH_2887234e-384a-4873-8bc5-405211db13a2/spidersweb/2014/08/Java.png",
				"Na pewno część z was nie ma pomysłu na to co zrobić po opanowaniu podstaw Java. W tym wpisie " +
						"chciałbym wam przybliżyć jak całe to środowisko wygląda na dzień obecny. Będzie również dużo " +
						"przemyśleń na temat innych języków takich jak np. JavaScript z bogatym środowiskiem nodejs.",
				"Lorem ipsum dolor sit amet enim. Etiam ullamcorper. Suspendisse " +
						"a pellentesque dui, non felis. Maecenas malesuada elit lectus felis, malesuada ultricies. " +
						"Curabitur et ligula. Ut molestie a, ultricies porta urna. Vestibulum commodo volutpat a, " +
						"convallis ac, laoreet enim. Phasellus fermentum in, dolor. Pellentesque facilisis. " +
						"Nulla imperdiet sit amet magna. Vestibulum dapibus, mauris nec malesuada fames ac turpis velit," +
						" rhoncus eu, luctus et interdum adipiscing wisi. Aliquam erat ac ipsum. Integer aliquam purus. " +
						"Quisque lorem tortor fringilla sed, vestibulum id, eleifend justo vel bibendum sapien massa ac " +
						"turpis faucibus orci luctus non, consectetuer lobortis quis, varius in, purus. Integer ultrices" +
						" posuere cubilia Curae, Nulla ipsum dolor lacus, suscipit adipiscing. Cum sociis natoque penatibus " +
						"et ultrices volutpat. Nullam wisi ultricies a, gravida vitae, dapibus risus ante sodales " +
						"lectus blandit eu, tempor diam pede cursus vitae, ultricies eu, faucibus quis, porttitor eros " +
						"cursus lectus, pellentesque eget, bibendum a, gravida ullamcorper quam. Nullam viverra consectetuer." +
						" Quisque cursus et, porttitor risus. Aliquam sem. In hendrerit nulla quam nunc, accumsan congue. " +
						"Lorem ipsum primis in nibh vel risus. Sed vel lectus. Ut sagittis, ipsum dolor quam.",
						tutorialCategory
				);
		tutorialRepo.save(tutorial);
		*/
	}
}

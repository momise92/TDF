package com.trucdeouf;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.trucdeouf.dao.CategorieRepository;
import com.trucdeouf.dao.CommentRepository;
import com.trucdeouf.dao.PostRepository;
import com.trucdeouf.dao.RoleRepository;
import com.trucdeouf.dao.UserRepository;
import com.trucdeouf.entities.Categorie;
import com.trucdeouf.entities.Comment;
import com.trucdeouf.entities.Post;
import com.trucdeouf.entities.Role;
import com.trucdeouf.entities.User;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude={UserDetailsServiceAutoConfiguration.class})
@EnableSwagger2
public class TrucDeOufApplication implements CommandLineRunner {

	@Autowired
	PostRepository postRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	CommentRepository commentRepository;
	@Autowired
	CategorieRepository categorieRepository;
	@Autowired
	RoleRepository roleRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TrucDeOufApplication.class, args);
	}
	
	@Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.trucdeouf.controller"))
                .paths(PathSelectors.any())
                .build();
    }

	@Override
	public void run(String... args) throws Exception {
		
		Role admin = new Role(null,"ADMIN",null);
		roleRepository.save(admin);
		
		/*Set<Role> listRole = new HashSet<>();
		listRole.add(admin);*/
		
		User user1 = new User(null,"leboss2@email.com", "password", "Hasho", "Carter","mylastname",true);
		user1.addRole(admin);
		userRepository.save(user1);
		
		/*listUser.add(user1);*/
		Categorie action = new Categorie(null, "Action", null);
		categorieRepository.save(action);
		
		Post post1 = new Post("Test1", "Ceci est mon premier test", 1, user1, action, null);
		postRepository.save(post1);
		
		
		Comment commentaire = new Comment("De la bombe ton site", post1, user1);
		commentRepository.save(commentaire);
		
		postRepository.save(new Post("Test2", "Ceci est mon deuxieme test", 1, null, action, null));
	}

}


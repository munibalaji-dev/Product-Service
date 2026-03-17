package com.balaji.ProductService;
import com.balaji.ProductService.inheritanceExample.tableperclass.User;
import com.balaji.ProductService.inheritanceExample.joinedtable.Student;
import com.balaji.ProductService.inheritanceExample.joinedtable.Mentor;
import com.balaji.ProductService.inheritanceExample.joinedtable.MentorRepository;
import com.balaji.ProductService.inheritanceExample.joinedtable.StudentRepository;
import com.balaji.ProductService.inheritanceExample.tableperclass.UserRepository;
import com.balaji.ProductService.models.Category;
import com.balaji.ProductService.models.Price;
import com.balaji.ProductService.models.Product;
import com.balaji.ProductService.repositories.CategoryRepository;
import com.balaji.ProductService.repositories.PriceRepository;
import com.balaji.ProductService.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class ProductserviceApplication implements CommandLineRunner {

	private StudentRepository studentRepository;
	private MentorRepository mentorRepository;

	private CategoryRepository categoryRepository;
	private ProductRepository productRepository;
	private PriceRepository priceRepository;

	public ProductserviceApplication(StudentRepository studentRepository,
									 MentorRepository mentorRepository,
									 CategoryRepository categoryRepository,
									 ProductRepository productRepository,
									 PriceRepository priceRepository
									 ){

		this.studentRepository = studentRepository;
		this.mentorRepository = mentorRepository;
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
		this.priceRepository = priceRepository;
	}

	public static void main(String[] args)  {
		SpringApplication.run(ProductserviceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Mentor mentor = new Mentor();
//		mentor.setName("Balaji");
//		mentor.setEmail("b@gmail.com");
//		mentor.setAvgRating(100.0);
//
//		mentorRepository.save(mentor);

//		User user1 = new User();
//		user1.setName("Balaji");
//		user1.setEmail("B@gmail.com");
//
//		userRepository.save(user1);
//
//		List<User> users = userRepository.findAll();
//		users.forEach(user -> {
//			System.out.println(user);
//		});
//		for (User user : users) {
//			System.out.println(user);
//		}


//		Student student1 = new Student();
//		student1.setName("Krish");
//		student1.setEmail("K@gmail.com");
//		student1.setPsp(90.0);
//		student1.setBatch("batch1");
//		studentRepository.save(student1);

//		Student student = new Student();
//		student.setName("Balaji Yadav");
//		student.setBatch("batch2");
//		student.setPsp(99.0);
//		student.setEmail("balaji@gmail.com");
//
//		studentRepository.save(student);


		Category category = new Category();
		category.setName("electronics");

		Category savedCategory = categoryRepository.save(category);

		Price price = new Price("Rupee",100.0);
		Price savedPrice = priceRepository.save(price);

		Product product = new Product();
		product.setTitle("I Phone 16");
		product.setDescription("Best Mobile Phone");
		product.setImage("Image Url");
		product.setCategory(savedCategory);
		product.setPrice(savedPrice);


		productRepository.save(product);

//		Optional<Category> optionalCategory = categoryRepository.
//				findById(UUID.fromString("550e8400-e29b-41d4-a716-446655440000"));
//
//		if (!optionalCategory.isPresent	()){
//			Category category1 = optionalCategory.get();
//			System.out.println("DEBUG");
//		}


	}
}

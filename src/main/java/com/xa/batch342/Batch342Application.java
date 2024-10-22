package com.xa.batch342;

// import java.util.Locale;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.xa.batch342.entities.Category;
import com.xa.batch342.entities.OrderDetail;
import com.xa.batch342.entities.OrderHeader;
import com.xa.batch342.entities.Product;
import com.xa.batch342.entities.Variant;
import com.xa.batch342.repositories.CategoryRepository;
import com.xa.batch342.repositories.OrderDetailRepository;
import com.xa.batch342.repositories.OrderHeaderRepository;
import com.xa.batch342.repositories.ProductRepository;
import com.xa.batch342.repositories.VariantRepository;

@SpringBootApplication
public class Batch342Application {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	VariantRepository variantRepository;

	@Autowired
	OrderHeaderRepository orderHeaderRepository;

	@Autowired
	OrderDetailRepository orderDetailRepository;

	public static void main(String[] args) {
		SpringApplication.run(Batch342Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(){
		return args -> {
			if (categoryRepository.count() == 0){
				// Category Seeding
			Category food = new Category("Food", "food",  true);
			Category beverage = new Category("Beverage", "beverage", true);
			Category medicine = new Category("Medicine", "medicine",  true);
			// Category fastFood = new Category("Fast Food", "fast-food");
			categoryRepository.save(food);
			categoryRepository.save(beverage);
			categoryRepository.save(medicine);
			// categoryRepository.save(fastFood);

			// Faker faker = new Faker(new Locale("es"));
			// int categories = 5;
			// for (int i = 0; i < categories; i++) {
			// 	Category categorySeed = new Category(faker.name().fullName(), faker.internet().slug());
			// 	categoryRepository.save(categorySeed);
			// }

			Product indomie = new Product("Instant Noodle", "instant-noodle", 1L, true);
			Product dairy = new Product("Dairy", "dairy", 2L, true);
			Product paracetamol = new Product("Paracetamol", "paracetamol", 3L, true);
			productRepository.save(indomie);
			productRepository.save(dairy);
			productRepository.save(paracetamol);
			
			
			Variant goreng = new Variant("Indomie goreng", 1L, "indomie-goreng asik", "mie rebus tidak digoreng", new BigDecimal(5000), new BigDecimal(300), true);
			Variant milku = new Variant("Milku Cokelat", 2L, "susu choco", "Susu rasa cokelat...", new BigDecimal(4500), new BigDecimal(250), true);
			Variant sanmol = new Variant("Sanmol", 3L, "sanmolin", "pereda panas", new BigDecimal(1500.00), new BigDecimal(3000),true);
			variantRepository.save(goreng);
			variantRepository.save(milku);
			variantRepository.save(sanmol);

			OrderHeader oh1 = new OrderHeader(new BigDecimal(150), true);
			orderHeaderRepository.save(oh1);

			OrderDetail od1 = new OrderDetail(new BigDecimal(150), 1L, 3L, new BigDecimal(1500), true);
			orderDetailRepository.save(od1);
			}
		};
	}
}

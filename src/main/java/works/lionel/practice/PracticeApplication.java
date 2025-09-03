package works.lionel.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import works.lionel.practice.product.ProductDTO;
import works.lionel.practice.product.ProductService;

@SpringBootApplication
public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args)
				.getBean(ProductService.class)
				.createProduct(new ProductDTO("baeldung", "course", 10));
	}

}

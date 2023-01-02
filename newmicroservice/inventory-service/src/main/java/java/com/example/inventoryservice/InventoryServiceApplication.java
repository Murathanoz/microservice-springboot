package java.com.example.inventoryservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.com.example.inventoryservice.model.Inventory;
import java.com.example.inventoryservice.repository.InventoryRepository;

@SpringBootApplication()
@ComponentScan("com.example.inventoryservice")
@EnableJpaRepositories(basePackageClasses = InventoryRepository.class)
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);

	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return args->{
			Inventory inventory=new Inventory();
			inventory.setCode("Iphone-3");
			inventory.setQuantity(120);
			inventoryRepository.save(inventory);
		};
	}
}

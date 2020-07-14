package harekrishan.all;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HarekrishanwebservicejpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HarekrishanwebservicejpaApplication.class, args);
	}

}


  package harekrishan.web;
  
  import org.springframework.boot.SpringApplication; import
  org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
  
  @SpringBootApplication 

  @ComponentScan(basePackages = {"harekrishan"})
  
  @EntityScan(basePackages = {"harekrishan"})
  
  @EnableJpaRepositories(basePackages = {"harekrishan"})
 
  public class HarekrishanMainApplicationStart { 
	  public static void main(String[] args) {
  SpringApplication.run(HarekrishanMainApplicationStart.class, args); }
  
  }
 
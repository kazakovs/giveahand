package net.hackyeah.giveahand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@EntityScan(
		basePackageClasses = { GiveahandApplication.class, Jsr310JpaConverters.class }
)
@SpringBootApplication
public class GiveahandApplication {
	public static void main(String[] args) {
		SpringApplication.run(GiveahandApplication.class, args);
	}
}

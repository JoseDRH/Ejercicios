package com.example.block5profiles;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Block5ProfilesApplication implements CommandLineRunner {

	//Para usar los perfiles correspondientes usar las run configuration
	//UserInt, UserPro y UserLocal
	//En caso de no estar guardadas, al crear la run configuration abrir el menu de modify options(o pulsar alt+m)
	//Y seleccionar ADD VM options, y añadir "-Dspring.profiles.active=*nombre del perfil*"

	public static void main(String[] args) {
		SpringApplication.run(Block5ProfilesApplication.class, args);
	}
	@Value("${spring.profiles.name}")
	private String perfil;

	@Value("${bd.url}")
	private String url;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(perfil);
		System.out.println(url);
	}
}

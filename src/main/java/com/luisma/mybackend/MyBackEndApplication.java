package com.luisma.mybackend;

import com.luisma.mybackend.enumeration.Status;
import com.luisma.mybackend.model.Server;
import com.luisma.mybackend.repository.ServerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.luisma.mybackend.enumeration.Status.SERVER_UP;

@SpringBootApplication
public class MyBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBackEndApplication.class, args);
	}

	@Bean
	CommandLineRunner run(ServerRepository serverRepository) {
		return args -> {
			serverRepository.save(new Server(null, "163.10.5.21", "Ubuntu", "16 Gb",
					"Mi maq", "http://localhost:8080/server/image/server1.png", SERVER_UP));
			serverRepository.save(new Server(null, "163.10.5.58", "Windows", "32 Gb",
					"Otra maq", "http://localhost:8080/server/image/server2.png", SERVER_UP));
			serverRepository.save(new Server(null, "163.10.5.160", "Fedora", "8 Gb",
					"Web Server", "http://localhost:8080/server/image/server3.png", SERVER_UP));
			serverRepository.save(new Server(null, "163.10.5.14", "Red hat", "64 Gb",
					"Mail Server","http://localhost:8080/server/image/server4.png", SERVER_UP));
		};
	}


}

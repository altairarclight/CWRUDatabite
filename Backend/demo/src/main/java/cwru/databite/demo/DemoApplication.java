package demo.src.main.java.cwru.databite.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		System.setProperty("server.port", 8081);
		System.setProperty("http.maxConnections", "10");

		SpringApplication.run(DataBiteBE.class, args);
	}

}

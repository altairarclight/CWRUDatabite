package cwru.databite.databite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan({ "com.delivery.request" })
public class DatabiteApplication implements CommandLineRunner {

	// @Autowired
	// private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(DatabiteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String sql = "INSERT INTO user (username, password, companyID) VALUES (?, ?, ?)";
		// int result = jdbcTemplate.update(sql, "sample@domain.com", "password",
		// "654321");
		// if (result > 0) {
		// System.out.println("New row");
		// }
	}

	// @Bean(name = "entityManagerFactory")
	// public LocalSessionFactoryBean sessionFactory() {
	// LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	// return sessionFactory;
	// }
}

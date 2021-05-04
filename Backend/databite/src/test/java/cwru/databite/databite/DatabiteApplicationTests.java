package cwru.databite.databite;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cwru.databite.databite.Tables.User;
import cwru.databite.databite.Tables.UserRepository;

@SpringBootTest
class DatabiteApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	void itemExistsWhenFoundByUsername() {
		User user = userRepository.findByUsername("email@domain.com").stream().findFirst().get();
		assertNotNull(user);
	}

}

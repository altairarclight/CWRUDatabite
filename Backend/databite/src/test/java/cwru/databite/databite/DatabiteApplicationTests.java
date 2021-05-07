package cwru.databite.databite;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cwru.databite.databite.Implementation.CompanyAdminImpl;
import cwru.databite.databite.Implementation.UserImpl;
import cwru.databite.databite.Tables.Company;
import cwru.databite.databite.Tables.CompanyRepository;
import cwru.databite.databite.Tables.DataSetRepository;
import cwru.databite.databite.Tables.User;
import cwru.databite.databite.Tables.UserDataSetsRepository;
import cwru.databite.databite.Tables.UserRepository;

@SpringBootTest
class DatabiteApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private UserDataSetsRepository userDSRepo;

	@Autowired
	private DataSetRepository dsRepo;

	private CompanyAdminImpl compAdminImpl;
	private UserImpl userImpl;

	@Test
	void itemExistsWhenFoundByUsername() {
		User user = userRepository.findByUsername("email@domain.com").stream().findFirst().get();
		assertNotNull(user);
	}

	@Test
	void itemExistsWhenFoundByCompanyName() {
		Company company = companyRepository.findByCompanyName("Test Company").stream().findFirst().get();
		assertNotNull(company);
	}

	@Test
	void getCompanyUsers() {
		Collection<User> userList = userRepository.findCompanyUsers(123456);
		for (User user : userList) {
			assertEquals(user.getCompany().getCompanyID(), 123456);
		}
	}

	@Test
	void getCompanyUsers2() {
		compAdminImpl = new CompanyAdminImpl(userRepository, userDSRepo, dsRepo);

		List<String> companyUsers = compAdminImpl.getCompanyUsers(123456);

		assertTrue(companyUsers.contains("email@domain.com"));
		// assertTrue(companyUsers.contains("sample@domain.com"));
	}

	@Test
	void userUpdatePassword() {
		userImpl = new UserImpl(userRepository, userDSRepo, dsRepo);

		userImpl.updatePassword("email@domain.com", "newpassword");
		assertTrue(userImpl.userGet("email@domain.com").getPassword().equals("newpassword"));
	}

	@Test
	void userDeleteAccount() {
		userImpl = new UserImpl(userRepository, userDSRepo, dsRepo);

		userImpl.userDelete("sample@domain.com");
		assertNull(userImpl.userGet("sample@domain.com"));
	}

	@Test
	void userRegister() {
		userImpl = new UserImpl(userRepository, userDSRepo, dsRepo);

		userImpl.userRegistration("sample@domain.com", "password");
		assertNotNull(userImpl.userGet("sample@domain.com"));
	}

	// @Test
	// void updateDataSetPermissionsForUser() {
	// userImpl = new UserImpl(userRepository, userDSRepo, dsRepo);

	// assertTrue(userImpl.updateDataSetPermission("email@domain.com", 1, false));
	// }
}

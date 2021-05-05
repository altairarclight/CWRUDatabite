package cwru.databite.databite.Tables;

import org.springframework.security.core.userdetails.UserDetails;

public class UserAccountDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByUsername(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("Incorrect username");
		}
	return new UserAccountDetails(user);
	}
}

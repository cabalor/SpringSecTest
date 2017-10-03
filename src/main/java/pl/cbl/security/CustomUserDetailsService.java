package pl.cbl.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import pl.cbl.data.User;
import pl.cbl.data.UserRoles;
import pl.cbl.repo.UserRepo;

public class CustomUserDetailsService implements UserDetailsService {
	
	
	private UserRepo userRepo;

	@Autowired
    public void setUserRepository(UserRepo userRepository) {
        this.userRepo = userRepository;
    }
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByEmail(username);
		if (user == null)
			throw new UsernameNotFoundException("user not exists in database");
		org.springframework.security.core.userdetails.User userData = new org.springframework.security.core.userdetails.User(
				user.getEmail(), user.getPassword(), convertAuthorities(user.getRoles()));

		return userData;

	}

	private Set<GrantedAuthority> convertAuthorities(Set<UserRoles> userRol) {
		Set<GrantedAuthority> auth = new HashSet<>();
		for (UserRoles ur : userRol) {
			auth.add(new SimpleGrantedAuthority(ur.getRole()));
		}
		return auth;

	}
}

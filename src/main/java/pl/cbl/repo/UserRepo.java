package pl.cbl.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.cbl.data.User;

public interface UserRepo extends JpaRepository<User, Long> {

	User findByEmail(String email);
	
	
}

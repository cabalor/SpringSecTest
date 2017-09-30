package pl.cbl.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.cbl.data.UserRoles;

public interface UserRolesRepo extends JpaRepository<UserRoles, Long> {

	UserRoles findByRole(String role);
	
	
}

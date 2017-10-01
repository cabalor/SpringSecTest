package pl.cbl.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.cbl.data.User;
import pl.cbl.data.UserRoles;
import pl.cbl.repo.UserRepo;
import pl.cbl.repo.UserRolesRepo;

@Service
public class UserService {

	private static final String Role = "Role_User";
	private UserRepo userRepo;
	private UserRolesRepo userRoleRepo;
	
	@Autowired
    public void setUserRepository(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
     
    @Autowired
    public void setRoleRepository(UserRolesRepo userRoleRepo) {
        this.userRoleRepo = userRoleRepo;
    }
	
    public void addDefRole(User user) {
        UserRoles defRole = userRoleRepo.findByRole(Role);
        user.getRoles().add(defRole);
        userRepo.save(user);
    }
	
	
}

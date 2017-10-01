package pl.cbl.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.cbl.data.User;
import pl.cbl.data.UserRoles;
import pl.cbl.repo.UserRepo;
import pl.cbl.repo.UserRolesRepo;

@Service // you can use @component here but service is more proper in place where you have a service like here.
public class UserService {

	private static final String Role = "Role User";
	
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private UserRolesRepo userRoleRepo;
	
	
    public void setUserRepository(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
     

    public void setRoleRepository(UserRolesRepo userRoleRepo) {
        this.userRoleRepo = userRoleRepo;
    }
	
    public void addDefRole(User user) {
        UserRoles defRole = userRoleRepo.findByRole(Role);
        user.getRoles().add(defRole);
        userRepo.save(user);
    }
	
	
}

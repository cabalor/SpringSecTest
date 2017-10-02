package pl.cbl.controll;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pl.cbl.data.User;
import pl.cbl.security.UserService;

@Controller
public class UserController {
	
	private UserService userSer;
	@Autowired
	public void setUserSErv(UserService US) {
		this.userSer = US;
	}
	
	
	@GetMapping("/register")
	public String register(Model m) {
		User user=new User();
		m.addAttribute("user",user );
		return "register";
	}
	
	@PostMapping("/register")
	public String registerPost(@Valid User user, BindingResult result) {
		
		if(result.hasErrors()) {
			return "register";
		}
		userSer.addDefRole(user);
		return "regSuc";
	}
	
	
}

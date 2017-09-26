package pl.cbl.controll;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	
	@RequestMapping("/")
	public String start(Model m) {
		
		m.addAttribute("msg", "this is kraken, hello here");
		return "main";
	}
	
	
}
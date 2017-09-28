package pl.cbl.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecuCfg extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
        	http
        		.authorizeRequests().antMatchers("/")
        		.permitAll().anyRequest().authenticated()
        		.and().formLogin();
    }
	@Override
	protected void configure(AuthenticationManagerBuilder authoryzation) throws Exception {
		
		
		
		authoryzation.inMemoryAuthentication().withUser("cbl").password("password").roles("USER"); // with this method we can create an user and set a login and password for him
    }
	
	
}

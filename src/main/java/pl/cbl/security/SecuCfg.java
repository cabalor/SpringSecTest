package pl.cbl.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;



@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "pl.cbl.*")
@EnableJpaRepositories(basePackages = "pl.cbl.*")
public class SecuCfg extends WebSecurityConfigurerAdapter{
	
	
	@Bean
    public UserDetailsService customUserDetailsService() {
        return new CustomUserDetailsService();
    }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
        	http.csrf().disable();
        		http.authorizeRequests().antMatchers("/", "/register")
        		.permitAll().anyRequest().authenticated()
        		.and()
        		.formLogin().loginPage("/form").permitAll()
        		.loginProcessingUrl("/loginProc").permitAll()
        		.usernameParameter("username")
        		.passwordParameter("password")
        		.and()
        		.logout()
        		.logoutUrl("/logout")
        		.logoutSuccessUrl("/").permitAll();
    }
	/*@Override
	protected void configure(AuthenticationManagerBuilder authoryzation) throws Exception {
		authoryzation.inMemoryAuthentication().withUser("cbl").password("password").roles("USER"); // with this method we can create an user and set a login and password for him
    }*/
	
	
}

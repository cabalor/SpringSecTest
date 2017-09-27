package pl.cbl.AppStart;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "pl.cbl.*")
public class WebConf extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver viewResolver() {

		InternalResourceViewResolver vRes = new InternalResourceViewResolver();

		vRes.setViewClass(JstlView.class);
		vRes.setPrefix("/WEB-INF/views/");
		vRes.setSuffix(".jsp");

		return vRes;

	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

}
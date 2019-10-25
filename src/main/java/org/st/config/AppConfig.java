package org.st.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("org.st")
@PropertySource("classpath:app.properties")
@EnableWebMvc
@Import(SecurityConfig.class)
public class AppConfig{
	
	@Autowired
	private Environment env;
	
	@Bean
	public InternalResourceViewResolver ivr() {
		InternalResourceViewResolver iv=new InternalResourceViewResolver();
		iv.setPrefix(env.getProperty("mvc.prefix"));
		iv.setSuffix(env.getProperty("mvc.suffix"));
		return iv;
	}
	
	@Bean
	public BCryptPasswordEncoder bpen() {
		
		return new BCryptPasswordEncoder();
	}

}

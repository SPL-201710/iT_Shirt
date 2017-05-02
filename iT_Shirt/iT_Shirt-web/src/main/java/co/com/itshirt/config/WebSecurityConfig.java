package co.com.itshirt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.mem.InMemoryUsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInController;

import co.com.itshirt.repository.service.FacebookConnectionSignup;
import co.com.itshirt.repository.service.FacebookSignInAdapter;

@Configuration
//@EnableWebMvcSecurity
@EnableWebSecurity
//@ComponentScan(basePackages = { "co.com.itshirt" })
//@ComponentScan(basePackageClasses = CustomUserDetailsService.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

 @Autowired 
 private UserDetailsService userDetailsService;
 @Autowired
 private ConnectionFactoryLocator connectionFactoryLocator;
 @Autowired
 private UsersConnectionRepository usersConnectionRepository;
 @Autowired
 private FacebookConnectionSignup facebookConnectionSignup;
 
 @Autowired
 public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {    
	 auth.userDetailsService(userDetailsService);//.passwordEncoder(passwordencoder());
 } 
 

 
 @Override
 protected void configure(HttpSecurity http) throws Exception {
//   http.authorizeRequests()
//  .antMatchers("/hello").access("hasRole('ROLE_ADMIN')")
//  .anyRequest().permitAll()
//  .and()
//    .formLogin().loginPage("/login")
//    .usernameParameter("username").passwordParameter("password")
//  .and()
//    .logout().logoutSuccessUrl("/login?logout") 
//   .and()
//   .exceptionHandling().accessDeniedPage("/403")
//  .and()
//    .csrf();
	 http.authorizeRequests()
	 .antMatchers("/login*","/signin/**","/signup/**").permitAll()
	//  .antMatchers("/hello").access("hasRole('ROLE_ADMIN')")
	  .anyRequest().permitAll()
	  .and()
	    .formLogin().loginPage("/login")
	    .usernameParameter("username").passwordParameter("password")
	  .and()
	    .logout().logoutSuccessUrl("/login?logout") 
	   .and()
	   .exceptionHandling().accessDeniedPage("/403")
	  .and()
	    .csrf().disable();
//	 
//   http
//   .csrf().disable()
//   .authorizeRequests()
//   .antMatchers("/login*","/signin/**","/signup/**").permitAll()
//   .anyRequest().authenticated()
//   .and()
//   .formLogin().loginPage("/login").permitAll()
//   .and()
//   .logout();
 }
 
 	@Bean(name="passwordEncoder")
    public PasswordEncoder passwordencoder(){
     return new BCryptPasswordEncoder();
    }
 
	 @Bean
	 // @Primary
	 public ProviderSignInController providerSignInController() {
//		 JOptionPane.showMessageDialog(null, "Entro a Security");
	     ((InMemoryUsersConnectionRepository) usersConnectionRepository).setConnectionSignUp(facebookConnectionSignup);
	     return new ProviderSignInController(connectionFactoryLocator, usersConnectionRepository, new FacebookSignInAdapter());
	 }
}
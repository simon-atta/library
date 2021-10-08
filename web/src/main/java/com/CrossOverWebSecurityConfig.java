package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

/**
 * Security Configuration class. This class contains all security rules.
 *
 * @author Simon Ghobreil.
 */
@Configuration
public class CrossOverWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers("/signup").permitAll().anyRequest().authenticated().and().formLogin()
                .loginPage("/login").defaultSuccessUrl("/library", true).failureUrl("/login")
                .failureHandler(authenticationFailureHandler).permitAll().and()
                // Logout
                .logout().invalidateHttpSession(false).logoutSuccessUrl("/login").deleteCookies("JSESSIONID")
                .permitAll().and()
                // Session Management
                .sessionManagement().enableSessionUrlRewriting(false).sessionFixation().none();

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/admin/**").antMatchers("/global/**").antMatchers("/plugins/**")
                .antMatchers("/image/**").antMatchers("/js/*").antMatchers("/ico/**");
    }

}
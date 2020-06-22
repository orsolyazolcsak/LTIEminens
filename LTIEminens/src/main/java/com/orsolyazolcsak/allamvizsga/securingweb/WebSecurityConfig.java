package com.orsolyazolcsak.allamvizsga.securingweb;

import com.orsolyazolcsak.allamvizsga.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;

    @Autowired
    public WebSecurityConfig(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/test/new/**").hasAuthority("Teacher")
                .antMatchers("/test").hasAuthority("Teacher")
                .antMatchers("/exam/new/**").hasAuthority("Teacher")
                .and().httpBasic()
        ;

//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                //.formLogin().and()
//                .httpBasic();

//.authorizeRequests()
//                    .antMatchers("/").permitAll()
//                    .anyRequest().authenticated()
//                    .and()
//                .formLogin()
//                    .loginPage("/login")
//                    .permitAll()
//                    .and()
//                .logout()
//                    .permitAll();


        // TODO secure vizsga indito oldal legalabb csak a Teacher role indithat vizsgat
//        http.httpBasic().and().authorizeRequests()
//                .antMatchers("/").permitAll()
//                .antMatchers("/protected").hasRole("USER")
//                .antMatchers("/admin").hasRole("ADMIN");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(new CustomAuthenticationProvider(userService));
    }
}


package com.orsolyazolcsak.allamvizsga.securingweb;

import com.orsolyazolcsak.allamvizsga.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

//@Configuration
//@EnableOAuth2Sso
public class WebSecurityConfig //extends WebSecurityConfigurerAdapter
{

    private final UserService userService;

    @Autowired
    public WebSecurityConfig(UserService userService) {
        this.userService = userService;
    }
// TODO megnezni hogy kell hasznalni ezt reacttel meg minden. tortenet. https://dzone.com/articles/integrating-spring-boot-and-react-with-spring-secu-1
//    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/", "/login**")
                .permitAll()
                .anyRequest()
                .authenticated();
                /*.authorizeRequests()
                    .antMatchers("/").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .and()
                .logout()
                    .permitAll();*/
        // TODO secure vizsga indito oldal legalabb csak a Teacher role indithat vizsgat
//        http.httpBasic().and().authorizeRequests()
//                .antMatchers("/").permitAll()
//                .antMatchers("/protected").hasRole("USER")
//                .antMatchers("/admin").hasRole("ADMIN");
    }

//    @Bean
//    @Override
//    public UserDetailsService userDetailsService(){
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                    .username("user")
//                    .password("password")
//                    .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//    }

//    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(new CustomAuthenticationProvider(userService));
    }
}

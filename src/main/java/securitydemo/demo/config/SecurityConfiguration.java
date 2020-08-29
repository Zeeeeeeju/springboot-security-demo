package securitydemo.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import securitydemo.demo.handler.SecurityAuthenticationFailHandler;
import securitydemo.demo.handler.SecurityAuthenticationSuccessHandler;
import securitydemo.demo.security.SecurityAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .exceptionHandling().authenticationEntryPoint(new SecurityAuthenticationEntryPoint())
                .and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/demo/ha").permitAll()
                .anyRequest().authenticated()
                .and().cors()
                .and().formLogin()
                .successHandler(new SecurityAuthenticationSuccessHandler())
                .failureHandler(new SecurityAuthenticationFailHandler())
                .loginProcessingUrl("/login");

    }

}

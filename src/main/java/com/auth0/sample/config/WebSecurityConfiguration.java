package com.auth0.sample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final Auth0LogoutHandler auth0LogoutHandler;

    public WebSecurityConfiguration(Auth0LogoutHandler auth0LogoutHandler) {
        this.auth0LogoutHandler = auth0LogoutHandler;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http.authorizeRequests()
                .antMatchers("/", "/webjars/**").permitAll()
                .anyRequest().authenticated()
            .and()
                .logout(l ->
                        l.addLogoutHandler(auth0LogoutHandler)
                          .logoutSuccessUrl("/").permitAll()
                )
                .oauth2Login()
                    .defaultSuccessUrl("/private/home");
        // @formatter:on
    }

}

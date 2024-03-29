package com.sisrest.configuration;

import com.sisrest.configuration.security.CustomUserDetailsService;
import com.sisrest.configuration.security.RestAuthenticationEntryPoint;
import com.sisrest.configuration.security.TokenAuthenticationFilter;
import com.sisrest.configuration.security.oauth2.CustomOAuth2UserService;
import com.sisrest.configuration.security.oauth2.HttpCookieOAuth2AuthorizationRequestRepository;
import com.sisrest.configuration.security.oauth2.OAuth2AuthenticationFailureHandler;
import com.sisrest.configuration.security.oauth2.OAuth2AuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private CustomOAuth2UserService customOAuth2UserService;

    @Autowired
    private OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler;

    @Autowired
    private OAuth2AuthenticationFailureHandler oAuth2AuthenticationFailureHandler;

    @Autowired
    private HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository;

    @Bean
    public TokenAuthenticationFilter tokenAuthenticationFilter() {
        return new TokenAuthenticationFilter();
    }

    /*
      By default, Spring OAuth2 uses HttpSessionOAuth2AuthorizationRequestRepository to save
      the authorization request. But, since our service is stateless, we can't save it in
      the session. We'll save the request in a Base64 encoded cookie instead.
    */
    @Bean
    public HttpCookieOAuth2AuthorizationRequestRepository cookieAuthorizationRequestRepository() {
        return new HttpCookieOAuth2AuthorizationRequestRepository();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().csrf().disable().formLogin().disable().httpBasic().disable().exceptionHandling().authenticationEntryPoint(new RestAuthenticationEntryPoint()).and().authorizeRequests().antMatchers("/", "/error", "/favicon.ico", "/**/*.png", "/**/*.gif", "/**/*.svg", "/**/*.jpg", "/**/*.html", "/**/*.css", "/**/*.js").permitAll().antMatchers("/auth/**", "/api/oauth2/**", "/oauth/**").permitAll()//
                .antMatchers(HttpMethod.GET, "/api/**").permitAll()//
                .antMatchers(HttpMethod.PATCH, "/api/**").permitAll()//
                .antMatchers(HttpMethod.POST, "/api/**").permitAll().antMatchers(HttpMethod.POST, "/api/login").permitAll()//
                .antMatchers(HttpMethod.POST, "/csv/**").permitAll().antMatchers(HttpMethod.POST, "/api/cardapioSemanal/**").permitAll().antMatchers(HttpMethod.POST, "/api/auth").permitAll()//
                .antMatchers(HttpMethod.POST, "/api/edital/**").permitAll()//
                .antMatchers(HttpMethod.GET, "/api/edital/**").permitAll()//
                .antMatchers(HttpMethod.PUT, "/api/edital/**").permitAll()//
                .antMatchers(HttpMethod.DELETE, "/api/edital/**").permitAll()//
//    				.antMatchers(HttpMethod.POST, "/api/user").permitAll()
                //.antMatchers(HttpMethod.POST, "/api/**").hasRole("ADMIN")
//    				.antMatchers(HttpMethod.GET, "/api/beneficiario/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/**").permitAll().antMatchers(HttpMethod.PUT, "/api/**").permitAll()
//    				.antMatchers(HttpMethod.POST, "/api/aluno/**").permitAll()
                //.antMatchers(HttpMethod.GET, "/api/**").hasAnyRole("USER","ADMIN")
                .anyRequest().authenticated().and().oauth2Login().authorizationEndpoint().baseUri("/oauth2/authorize").authorizationRequestRepository(cookieAuthorizationRequestRepository()).and().redirectionEndpoint().baseUri("/oauth2/callback/*").and().userInfoEndpoint().userService(customOAuth2UserService).and().successHandler(oAuth2AuthenticationSuccessHandler).failureHandler(oAuth2AuthenticationFailureHandler);

        // Add our custom Token based authentication filter
        //Adicionar nosso filtro de autenticação personalizado baseado em Token
        http.addFilterBefore(tokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

}


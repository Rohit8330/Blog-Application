//package com.example.BlogApplication.Configurations;
//
//import com.example.BlogApplication.Security.CustomUserDetailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.DefaultSecurityFilterChain;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//@EnableWebSecurity
//@Configuration
//@EnableWebMvc
////@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfig {
//
//    @Autowired
//    private CustomUserDetailService customUserDetailService;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        () -> http.
//                csrf()
//                .disable()
//                .authorizeHttpRequests()
//                .antMatchers(PUBLIC_URL)
//                .permitAll()
//                .antMatchers(HttpMethod.GET)
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and().exceptionHandling()
//                .authenticationEntryPoint(this.jwtAuthenticationEntryPoint)
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        http.addFilterBefore(this.jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//
//        http.authenticationProvider(daoAuthenticationProvider());
//        DefaultSecurityFilterChain defaultSecurityFilterChain = http.build();
//
//        return defaultSecurityFilterChain;
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
//        return configuration.getAuthenticationManager();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider() {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setUserDetailsService(this.customUserDetailService);
//        provider.setPasswordEncoder(passwordEncoder());
//
//        return provider;
//    }
//}

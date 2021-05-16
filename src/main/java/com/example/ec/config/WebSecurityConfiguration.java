package com.example.ec.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.example.ec.security.FirebaseAuthenticationFilter;
import com.example.ec.security.Role;
import com.example.ec.service.CustomerService;

/**
 * セキュリティ設定クラス。
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomerService customerService;

    @Value(value = "${app.allowedOrigin}")
    private String allowedOrigin;

    @Value(value = "${app.security.enable}")
    private boolean securityEnable;

    @Override
    public void configure(WebSecurity web) throws Exception {

        // 静的リソースに対するアクセスはセキュリティ設定を無視
        web.ignoring().antMatchers(
                "/**/css/**",
                "/**/js/**");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeRequests().antMatchers("/static/**", "/static/css/**", "/static/js/**").permitAll();
        httpSecurity.authorizeRequests().antMatchers("/api/open/**").permitAll();
        httpSecurity.authorizeRequests().antMatchers("/api/client/**").hasRole(Role.USER);
        httpSecurity.authorizeRequests().antMatchers("/api/admin/**").hasAnyRole(Role.ADMIN);
        httpSecurity.authorizeRequests().antMatchers("/health/**").hasAnyRole(Role.ADMIN);
        httpSecurity.authorizeRequests().antMatchers("/**").permitAll();
        httpSecurity.authorizeRequests().and().csrf().disable();

        if (securityEnable) {

            // Firebase認証フィルタを登録
            httpSecurity.addFilterBefore(new FirebaseAuthenticationFilter(customerService),
                    UsernamePasswordAuthenticationFilter.class);

            // CORS
            httpSecurity.cors();
        }
    }

    /**
     * CORS設定
     *
     * @return CORS設定
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.addAllowedMethod(CorsConfiguration.ALL);
        corsConfiguration.addAllowedHeader(CorsConfiguration.ALL);
        corsConfiguration.addAllowedOrigin(allowedOrigin);

        UrlBasedCorsConfigurationSource corsSource = new UrlBasedCorsConfigurationSource();
        corsSource.registerCorsConfiguration("/**", corsConfiguration);

        return corsSource;
    }
}

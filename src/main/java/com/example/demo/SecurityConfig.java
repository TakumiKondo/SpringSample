package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private DataSource dataSource;

    private static final String USER_SQL = ""
        + "SELECT"
            + " id"
            + " ,password"
            + " ,true"
        + " FROM"
            + " users"
        + " WHERE"
            + " id =?";

    private static final String ROLE_SQL = ""
            + "SELECT"
                + " id"
                + " ,role"
            + " FROM"
                + " users"
            + " WHERE"
                + " id =?";

    @Override
    public void configure(WebSecurity web) throws Exception {
        // セキュリティ適用の除外対象
        web.ignoring().antMatchers("/webjars/**", "/css/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // アクセス可能ページの設定
        http.authorizeRequests()
            .antMatchers("/webjars/**").permitAll()
            .antMatchers("/css/**").permitAll()
            .antMatchers("/login").permitAll()
            .antMatchers("/signup").permitAll()
            .antMatchers("/rest/**").permitAll()
            .antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
            .anyRequest().authenticated();

        // ログイン処理
        http.formLogin()
            .loginProcessingUrl("/login")
            .loginPage("/login")
            .failureUrl("/login")
            .usernameParameter("id")
            .passwordParameter("password")
            .defaultSuccessUrl("/home", true);

        // ログアウト
        http.logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .logoutUrl("/logout")
            .logoutSuccessUrl("/login");

        // CSRF無効化
//        http.csrf().disable();
        RequestMatcher csrfMatcher = new RestMatcher("/rest/**");
        http.csrf().requireCsrfProtectionMatcher(csrfMatcher);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
            .dataSource(dataSource)
            .usersByUsernameQuery(USER_SQL)
            .authoritiesByUsernameQuery(ROLE_SQL)
            .passwordEncoder(passwordEncoder());
    }

}

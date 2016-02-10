package com.ezdi.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.savedrequest.NullRequestCache;

import javax.sql.DataSource;

/**
 * Created by EZDI\manjunath.y on 9/2/16.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Primary
    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        System.out.println("YAJI: Created securityDataSource: "+driverManagerDataSource);
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/userSessionManagement");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("P@ssw0rd@123");
        System.out.println("YAJI: Returning securityDataSource");
        return driverManagerDataSource;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated().and().requestCache().requestCache(new NullRequestCache())
                .and().httpBasic();
    }

    /*
    //@Autowired
    @Resource(name="securityDataSource")
    DataSource securityDataSource;

    public DataSource getSecurityDataSource() {
        return securityDataSource;
    }

    //@Autowired
    //@Qualifier("securityDataSource")
    @Resource(name="securityDataSource")
    public void setSecurityDataSource(DataSource securityDataSource) {
        this.securityDataSource = securityDataSource;
    }
    */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, DataSource dataSource) throws Exception {

        System.out.println("YAJI: CONFIGUREGLOBAL SECURITY: "+dataSource);
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username,password, enabled from users where username=?")
                .authoritiesByUsernameQuery("select username, role from user_roles where username=?");

    }
}

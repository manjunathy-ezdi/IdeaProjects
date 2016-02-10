package com.ezdi.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.savedrequest.NullRequestCache;

/**
 * Created by EZDI\manjunath.y on 9/2/16.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /*
    @Bean(name = "securityDataSource")
    public DriverManagerDataSource securityDataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/userSessionManagement");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("P@ssw0rd@123");
        return driverManagerDataSource;
    }
*/
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


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(securityDataSource)
                .usersByUsernameQuery("select username,password, enabled from users where username=?")
                .authoritiesByUsernameQuery("select username, role from user_roles where username=?");

    }
    */
}

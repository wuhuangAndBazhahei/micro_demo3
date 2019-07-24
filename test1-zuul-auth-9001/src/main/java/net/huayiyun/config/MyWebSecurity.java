package net.huayiyun.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Project : eurekademo1
 * @Package Name : net.huayiyun.config
 * @Description : TODO
 * @Author : zlj
 * @Creation Date : 2019年07月08日 17:53
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
@Configuration
@EnableOAuth2Sso
public class MyWebSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf()
                .disable();
    }

}

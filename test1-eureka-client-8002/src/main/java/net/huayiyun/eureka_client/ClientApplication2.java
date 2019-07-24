package net.huayiyun.eureka_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @Project : eurekademo1
 * @Package Name : net.huayiyun.eureka_client
 * @Description : TODO
 * @Author : zlj
 * @Creation Date : 2019年06月26日 9:45
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableResourceServer
public class ClientApplication2 extends ResourceServerConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication2.class,args);
    }

    @Override
    public void configure(HttpSecurity http)throws Exception{
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/**").authenticated()
                .antMatchers("/openFeignSave").hasAuthority("WRIGTH_WRITE");
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources)throws Exception{
        resources
                .resourceId("WRIGTH")
                .tokenStore(jwtTokenStore());
    }

    @Bean
    public TokenStore jwtTokenStore() {
        return new JwtTokenStore(jwtTokenConverter());
    }

    @Bean
    protected JwtAccessTokenConverter jwtTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("hy_jwt");
        return converter;
    }
}

package net.huayiyun.eureka_client.security_config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @Project : eurekademo1
 * @Package Name : net.huayiyun.eureka_client.security_config
 * @Description : TODO
 * @Author : zlj
 * @Creation Date : 2019年07月08日 11:38
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
//@Configuration
//@EnableResourceServer
public class SecurityConfig  {

//    @Override  extends ResourceServerConfigurerAdapter
//    public void configure(HttpSecurity http)throws Exception{
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/**").authenticated()
//                .antMatchers("/openFeignSave").hasAuthority("WRIGTH_WRITE");
//    }
//
//    @Override
//    public void configure(ResourceServerSecurityConfigurer resources)throws Exception{
//        resources
//                .resourceId("WRIGTH")
//                .tokenStore(jwtTokenStore());
//    }
//
//    @Bean
//    public TokenStore jwtTokenStore() {
//        return new JwtTokenStore(jwtTokenConverter());
//    }
//
//    @Bean
//    protected JwtAccessTokenConverter jwtTokenConverter() {
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        converter.setSigningKey("hy_jwt");
//        return converter;
//    }
}

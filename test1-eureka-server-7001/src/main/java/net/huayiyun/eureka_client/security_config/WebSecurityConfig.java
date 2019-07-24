package net.huayiyun.eureka_client.security_config;


/**
 * @Project : eurekademo1
 * @Package Name : net.huayiyun.eureka_client.security_config
 * @Description : TODO
 * @Author : zlj
 * @Creation Date : 2019年07月08日 14:10
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
//@Configuration
//@EnableWebSecurity
public class WebSecurityConfig  {

//    /**
//     * @Description: 高版本的丢弃了 extends WebSecurityConfigurerAdapter
//     * security:
//     *   basic:
//     *     enabled: true 配置，应该使用以下方式开启
//     * @Param: [http]
//     * @Return: void
//     */
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // Configure HttpSecurity as needed (e.g. enable http basic).
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);
//        http.csrf().disable();
//        //注意：为了可以使用 http://${user}:${password}@${host}:${port}/eureka/ 这种方式登录,所以必须是httpBasic,
//        // 如果是form方式,不能使用url格式登录
//        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
//
//    }
}

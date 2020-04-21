package com.zzr.mall.config;



import com.zzr.mall.config.securityConfig.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    AuthenticationTokenFilter authenticationTokenFilter;
    @Autowired
    UserDetailsService userDetailsService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {



        //加入数据库验证类，下面的语句实际上在验证链中加入了一个DaoAuthenticationProvider
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

   /* *
     * 匹配 "/","/index" 路径，不需要权限即可访问
     * 匹配 "/user" 及其以下所有路径，都需要 "USER" 权限
     * 匹配 "/admin" 及其以下所有路径，都需要 "ADMIN" 权限
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/user/login","/user/register").permitAll()
                .antMatchers("/user/**","/index.html","/").hasRole("USER")
                .anyRequest().permitAll()
                .and()
                .logout().logoutUrl("/user/logout").logoutSuccessHandler(new MyLogoutSuccessHandler())
                .deleteCookies("token")
                //拦截的url会重定向到loginPage；请求会交到login处理；成功到defaultSuccessUrl处理，失败由failureForwardUrl处理；
               /* .formLogin().loginProcessingUrl("/login").failureForwardUrl("/loginFailure").defaultSuccessUrl("/loginSuccess")*/
                //1.自定义参数名称，与login.html中的参数对应
               /* .usernameParameter("name").passwordParameter("password")*/
              /*  .and()*/
               /* .logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccess")
                .and()*/
                //添加token验证的filter
                .and()
                .addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
//禁用缓存
        http.headers().cacheControl();
        //添加自定义异常入口，处理entryPoint异常和accessDeny异常
        http.exceptionHandling().authenticationEntryPoint(new MyEntryPointHandler())
                .accessDeniedHandler(new MyAccessDeniedHandler());
    }
    @Bean
    PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}




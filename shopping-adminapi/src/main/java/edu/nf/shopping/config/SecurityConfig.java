//package edu.nf.shopping.config;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import edu.nf.shopping.user.service.UserService;
//import edu.nf.shopping.vo.ResponseVO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.access.AccessDeniedHandler;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * @author Vera
// * @date 2020/4/2
// */
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private UserService userService;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .formLogin()
//                .loginPage("/login.html")
//                .loginProcessingUrl("/user_login").permitAll()
//                .usernameParameter("userName")
//                .passwordParameter("password")
//                .successHandler(successHandler())
//                .failureHandler(failureHandler())
//                .and()
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .logout()
//                .logoutUrl("/log_out")
//                .logoutSuccessUrl("/login.html")
//                .invalidateHttpSession(true)
//                .deleteCookies("JSESSIONID")
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
//                .sessionFixation().migrateSession()
//                .invalidSessionUrl("/login.html")
//                .maximumSessions(1)
//                .maxSessionsPreventsLogin(true);
//
//
//    }
//
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/css/**","/js/**","/**/*.html",
//                "/**/*.jpg","/**/*.png");
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
//    }
//
//    /**
//     * 自定义403的响应处理
//     * @return
//     */
//    private AccessDeniedHandler accessDeniedHandler(){
//        return new AccessDeniedHandler() {
//            @Override
//            public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
//                httpServletResponse.setContentType("application/json;charset=utf-8");
//                ResponseVO vo=new ResponseVO();
//                vo.setCode(HttpStatus.FORBIDDEN.value());
//                vo.setMessage("没有访问权限");
//                ObjectMapper mapper=new ObjectMapper();
//                mapper.writeValue(httpServletResponse.getWriter(),vo);
//            }
//        };
//    }
//
//
//    /**
//     * 装配AuthenticationFailureHandler,
//     * 当验证未通过时，可以调用此对象来响应自定义验证消息
//     * @return
//     */
//    private AuthenticationFailureHandler failureHandler(){
//        return new AuthenticationFailureHandler() {
//            @Override
//            public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
//                httpServletResponse.setContentType("application/json;charset=utf-8");
//                ResponseVO vo=new ResponseVO();
//                vo.setCode(HttpStatus.UNAUTHORIZED.value());
//                vo.setMessage("账号或密码错误");
//                ObjectMapper mapper=new ObjectMapper();
//                mapper.writeValue(httpServletResponse.getWriter(),vo);
//            }
//        };
//    }
//
//
//    /**
//     * 自定义成功的消息响应
//     * @return
//     */
//    private AuthenticationSuccessHandler successHandler(){
//        return new AuthenticationSuccessHandler() {
//            @Override
//            public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
//                httpServletResponse.setContentType("application/json;charset=utf-8");
//                ResponseVO vo=new ResponseVO();
//                vo.setCode(HttpStatus.OK.value());
//                ObjectMapper mapper=new ObjectMapper();
//                mapper.writeValue(httpServletResponse.getWriter(),vo);
//            }
//        };
//    }
//
//
//
//}

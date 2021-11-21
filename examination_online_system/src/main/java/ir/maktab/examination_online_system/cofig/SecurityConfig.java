package ir.maktab.examination_online_system.cofig;

import ir.maktab.examination_online_system.cofig.security.RoleName;
import ir.maktab.examination_online_system.cofig.security.SecurityConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().
                disable().
                authorizeRequests()
                .mvcMatchers(SecurityConstant.getAdminPaths())
                .hasRole(RoleName.ADMIN)
                .mvcMatchers(SecurityConstant.getStudentPath())
                .hasRole(RoleName.STUDENT)
                .mvcMatchers(SecurityConstant.getTeacherPaths())
                .hasRole(RoleName.PROFESSOR)
                .mvcMatchers(SecurityConstant.getPermitAllUrls())
                .permitAll()
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated();

        http.formLogin().loginPage("/login").defaultSuccessUrl("/header").permitAll();

    }
}
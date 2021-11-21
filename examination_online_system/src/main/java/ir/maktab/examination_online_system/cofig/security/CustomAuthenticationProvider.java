package ir.maktab.examination_online_system.cofig.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (userDetails.isEnabled()) {

            if (passwordEncoder.matches(password, userDetails.getPassword())) {

                return new UsernamePasswordAuthenticationToken(
                        username,
                        password,
                        userDetails.getAuthorities()
                );

            } else {
                throw new BadCredentialsException("wrong pass!!!");
            }
        } else {
            throw new DisabledException("user is disabled!!!");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class)
                || authentication.equals(AnonymousAuthenticationToken.class);
    }
}

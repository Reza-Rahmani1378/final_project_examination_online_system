package ir.maktab.examination_online_system.cofig.security;

import ir.maktab.examination_online_system.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SecurityUser implements UserDetails {

    private final User user;

    public SecurityUser(User user) {
        this.user = user;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (user.getRoles() != null && !user.getRoles().isEmpty()) {
            user.getRoles()
                    .forEach(role -> {
                                authorities.add(
                                        new SimpleGrantedAuthority(
                                                "ROLE_".concat(role.getName())
                                        )
                                );
                            }
                    );
        }
        return authorities;

        /*return Collections.singletonList(
                new SimpleGrantedAuthority(
                        "read"
                )
        );*/
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return user.isConfirmed();
    }

    public User getUser() {
        return this.user;
    }
}

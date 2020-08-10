package novi.spring.security.services;

import java.util.Collection;

import lombok.Getter;
import lombok.Setter;
import novi.spring.helper.RoleConverter;
import novi.spring.model.Student;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AuthDetails implements UserDetails {

    @Getter
    private Long id;

    @Getter
    private String username;

    @Getter
    private String email;

    @Getter
    @JsonIgnore
    private String password;

    @Getter
    private Collection<GrantedAuthority> authorities;

    public AuthDetails(Student student) {
        this.id = student.getId();
        this.username = student.getName();
        this.email = student.getEmail();
        this.password = student.getPassword();
        this.authorities = RoleConverter.rolesToAuthorities(student.getRoles());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
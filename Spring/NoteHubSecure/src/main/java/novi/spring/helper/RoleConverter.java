package novi.spring.helper;

import novi.spring.repository.RoleRepository;
import novi.spring.model.users.Role;
import novi.spring.model.users.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class RoleConverter {

    @Autowired
    private RoleRepository roleRepository;

    public static List<GrantedAuthority> rolesToAuthorities(Collection<Role> roles)
    {
        return roles.stream()
            .map(role -> new SimpleGrantedAuthority(role.getName()) )
            .collect(Collectors.toList());
    }

    public static List<String> authoritiesToStrings(Collection<? extends GrantedAuthority> grants)
    {
        return grants.stream()
                .map(grant -> grant.getAuthority())
                .collect(Collectors.toList());
    }

    public List<Role> stringsToRoles(List<String> strRoles) {
        List<Role> roles = new ArrayList<>();
        roles.add(getRole(Roles.USER));
        if (strRoles != null && strRoles.contains("admin")) {
            roles.add(getRole(Roles.ADMIN));
        }

        return roles;
    }

    private Role getRole(Roles role) {
        Role userRole;
        Optional<Role> _userRole = roleRepository.findByName(role);
        if(!_userRole.isPresent()) {
            userRole = new Role(role);
            roleRepository.save(userRole);
        } else {
            userRole = _userRole.get();
        }
        return userRole;
    }
}

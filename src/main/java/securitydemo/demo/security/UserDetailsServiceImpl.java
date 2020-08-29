package securitydemo.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import securitydemo.demo.entity.SysUser;
import securitydemo.demo.repository.UserRepository;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        SysUser sysUser = userRepository.findUserByUsername(username);
        if (sysUser != null) {
            return new User(sysUser.getUsername(), new BCryptPasswordEncoder().encode(sysUser.getPassword()), new ArrayList<GrantedAuthority>());
        }
        throw new InternalAuthenticationServiceException("User " + username + " not exist");
    }
}

package com.golismarcin.riverslevelmonitor.security;

import com.golismarcin.riverslevelmonitor.security.model.RiverUserDetails;
import com.golismarcin.riverslevelmonitor.security.model.User;
import com.golismarcin.riverslevelmonitor.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RiverUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Transactional
    @Override
    public RiverUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findById(Long.parseLong(username)).orElseThrow();
        RiverUserDetails riverUserDetails = new RiverUserDetails(
                user.getUsername(),
                user.getPassword(),
                user.getAuthorities().stream()
                        .map(role -> (GrantedAuthority) role::name)
                        .toList()
        );
        riverUserDetails.setId(user.getId());
        return riverUserDetails;
    }
}

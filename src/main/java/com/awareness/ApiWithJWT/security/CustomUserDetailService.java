package com.awareness.ApiWithJWT.security;


import com.awareness.ApiWithJWT.model.User;
import com.awareness.ApiWithJWT.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User user = userRepo.findByUsernameOrEmail(usernameOrEmail,usernameOrEmail)
                .orElseThrow(() -> new UsernameNotFoundException("User with this username or email not found" + usernameOrEmail));
        return UserPrincipal.create(user);
    }


    @Transactional
    public UserDetails loadUserById(Long id) throws UsernameNotFoundException {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User with this id doesn't exists" + id));

        return UserPrincipal.create(user);

    }

}

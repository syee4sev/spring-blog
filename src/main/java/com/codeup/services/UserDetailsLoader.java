package com.codeup.services;

import com.codeup.models.User;
import com.codeup.models.UserWithRoles;
import com.codeup.repositories.Roles;
import com.codeup.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by everardosifuentes on 6/23/17.
 */

@Service("customUserDetailsService")
public class UserDetailsLoader implements UserDetailsService {

    private final UserRepository users;
    private final Roles roles;

    @Autowired
    public UserDetailsLoader(UserRepository users, Roles roles) {
        this.users = users;
        this.roles = roles;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = users.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user found for " + username);
        }

        List<String> userRoles = roles.ofUserWith(username);
        return new UserWithRoles(user, userRoles);
    }

}

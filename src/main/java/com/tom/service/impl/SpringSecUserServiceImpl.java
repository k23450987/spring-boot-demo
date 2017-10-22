package com.tom.service.impl;

import com.tom.dao.UserMapper;
import com.tom.model.Role;
import com.tom.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class SpringSecUserServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper dao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = dao.findByUsername(s);
        if (user == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                true, true, true, true, getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user) {
        List<GrantedAuthority> auths = new ArrayList<>();
        for (Role role : user.getRoles()) {
            auths.add(new SimpleGrantedAuthority(role.getName()));
        }
        return auths;
    }
}

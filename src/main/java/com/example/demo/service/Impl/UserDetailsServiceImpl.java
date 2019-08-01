package com.example.demo.service.Impl;



import com.example.demo.entity.po.User;
import com.example.demo.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserMapper userMapper;

    public UserDetailsServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        try {
            User user = userMapper.findByUsername(username);
            if (user == null) {
                throw new UsernameNotFoundException("User Not Found");
            }
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            if (StringUtils.isNotBlank(user.getRoles())) {
                String[] roles = user.getRoles().split(",");
                for (String role : roles) {
                    if (StringUtils.isNotBlank(role)) {
                        authorities.add(new SimpleGrantedAuthority(role.trim()));
                    }
                }
            }return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
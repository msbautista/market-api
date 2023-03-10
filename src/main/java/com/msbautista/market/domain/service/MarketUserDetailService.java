package com.msbautista.market.domain.service;

import com.msbautista.market.domain.User;
import com.msbautista.market.domain.repository.UserRepository;
import com.msbautista.market.web.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MarketUserDetailService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public MarketUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository
                .getByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("The user with username " + username + " does not exist"));
        return new UserDetailsImpl(user);
    }

}


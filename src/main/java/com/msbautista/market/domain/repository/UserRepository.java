package com.msbautista.market.domain.repository;

import com.msbautista.market.domain.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> getByUsername(String username);
}

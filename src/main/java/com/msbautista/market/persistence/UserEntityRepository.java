package com.msbautista.market.persistence;

import com.msbautista.market.domain.User;
import com.msbautista.market.domain.repository.UserRepository;
import com.msbautista.market.persistence.crud.UserCrudRepository;
import com.msbautista.market.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserEntityRepository implements UserRepository {

    private UserCrudRepository userCrudRepository;
    private UserMapper userMapper;

    @Autowired
    public UserEntityRepository(UserCrudRepository userCrudRepository, UserMapper userMapper) {
        this.userCrudRepository = userCrudRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return userCrudRepository.findOneByUsername(username).map(userEntity -> userMapper.toUser(userEntity));
    }

}

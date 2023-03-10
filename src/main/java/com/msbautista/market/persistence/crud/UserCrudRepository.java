package com.msbautista.market.persistence.crud;

import com.msbautista.market.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserCrudRepository extends CrudRepository<UserEntity, Integer> {

    Optional<UserEntity> findOneByUsername(String username);
}

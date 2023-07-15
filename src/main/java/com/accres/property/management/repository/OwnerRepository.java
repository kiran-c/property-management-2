package com.accres.property.management.repository;

import com.accres.property.management.entity.OwnerEntity;
import com.accres.property.management.entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OwnerRepository extends CrudRepository<OwnerEntity, Long> {

    Optional<OwnerEntity> findByOwnerEmailAndPassword(String email, String password);
}

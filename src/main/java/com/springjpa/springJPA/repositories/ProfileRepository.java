package com.springjpa.springJPA.repositories;

import com.springjpa.springJPA.entities.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends CrudRepository<Profile,Integer>{
    @Query("SELECT p FROM Profile as p WHERE p.user.id=?1 AND p.id=?2") //p.user.id=?1 el valor "1" indica que
        // el valor del id de usuario va a ser igual al 1er parametro de la funcion "findByUserIdAndProfileId"
        // y p.id=?2 el valor "2" indica que va a ser igual al 2do parametro de la funcion
    Optional<Profile> findByUserIdAndProfileId(Integer userId, Integer profileId);
}

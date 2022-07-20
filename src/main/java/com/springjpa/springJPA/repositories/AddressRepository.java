package com.springjpa.springJPA.repositories;

import com.springjpa.springJPA.entities.Address;
import com.springjpa.springJPA.entities.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// entre parentesis angulares se pone la entidad y el tipo de dato de la
// llave de esa entidad CrudRepository<Address,Integer>
@Repository
public interface AddressRepository extends CrudRepository<Address,Integer> {

    @Query("SELECT a FROM Address AS a WHERE a.profile.user.id=?1 AND a.profile.id=?2")
    List<Address> findAddressesByUserIdAndProfileId(Integer userId, Integer profileId);
}

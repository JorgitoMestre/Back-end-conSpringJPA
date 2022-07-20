package com.springjpa.springJPA.repositories;

import com.springjpa.springJPA.entities.Address;
import com.springjpa.springJPA.entities.User;
import com.springjpa.springJPA.entities.UserInRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.hibernate.loader.Loader.SELECT;
@Repository
public interface UserInRoleRepository extends JpaRepository<UserInRole,Integer> {
    //UserInRole findByUserAnd
    @Query("SELECT u FROM UserInRole AS u WHERE u.user.id=?1 AND u.role.id=?2")
    Optional<UserInRole>  getUserInRole(Integer userId, Integer roleId);

    @Query("SELECT u FROM UserInRole AS u WHERE u.user.id=?1")
    Optional <List<UserInRole>>  getAllRoleOfUser(Integer userId);


}

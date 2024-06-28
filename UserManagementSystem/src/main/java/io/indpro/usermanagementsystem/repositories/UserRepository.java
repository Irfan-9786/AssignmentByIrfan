package io.indpro.usermanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.indpro.usermanagementsystem.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}

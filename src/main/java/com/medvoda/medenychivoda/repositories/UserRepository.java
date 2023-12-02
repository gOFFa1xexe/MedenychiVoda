package com.medvoda.medenychivoda.repositories;

import com.medvoda.medenychivoda.Entity.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;


@EnableAutoConfiguration
public interface UserRepository extends JpaRepository<User,Long > {

}

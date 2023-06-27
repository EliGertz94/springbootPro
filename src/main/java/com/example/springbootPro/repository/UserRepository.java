package com.example.springbootPro.repository;


import com.example.springbootPro.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    boolean existsByUsernameAndPassword(String username,String password);
}

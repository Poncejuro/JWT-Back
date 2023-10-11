package com.example.demo.Repository;


import com.example.demo.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Controller
public interface UsersRepository extends JpaRepository<User,Long>{
    Optional<User> findByEmail(String email);
}

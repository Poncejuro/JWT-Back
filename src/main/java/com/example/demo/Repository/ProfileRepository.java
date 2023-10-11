package com.example.demo.Repository;

import com.example.demo.Entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface ProfileRepository extends JpaRepository<Profile,Long> {

}

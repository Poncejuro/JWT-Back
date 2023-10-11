package com.example.demo.Controller;

import com.example.demo.Entity.Profile;
import com.example.demo.Service.ProfileService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/profile")
@CrossOrigin(origins = "*")
@Log4j2 // to print in console
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @PostMapping
    public ResponseEntity<Profile> createProfile(@RequestBody Profile profile) {
        Profile newProfile = profileService.createProfile(profile);
        log.info("Creating a new profile.");
        return new ResponseEntity<>(newProfile, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List <Profile>>getAllProfiles() {
        List<Profile> profiles = profileService.getAllProfiles();
        log.info("Getting all profiles.");
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable Long id) {
        Profile user = profileService.getProfileById(id);
        log.info("Getting a user by Id.");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Profile> updateProfile(@RequestBody Profile profile, @PathVariable Long id) {
        Profile updateProfile= profileService.updateProfile(profile, id);
        log.info("Updating an existing profile.");
        return new ResponseEntity<>(updateProfile, HttpStatus.OK);
    }
}

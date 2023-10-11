package com.example.demo.Service;

import com.example.demo.Entity.Profile;

import java.util.List;

public interface ProfileService {

    Profile createProfile(Profile profile);

    List<Profile> getAllProfiles();

    Profile getProfileById(Long id);

    Profile updateProfile(Profile profile, Long id);


}

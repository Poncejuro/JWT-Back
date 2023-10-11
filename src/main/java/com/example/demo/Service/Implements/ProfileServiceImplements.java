package com.example.demo.Service.Implements;

import com.example.demo.Entity.Profile;
import com.example.demo.Repository.ProfileRepository;
import com.example.demo.Service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProfileServiceImplements implements ProfileService {
    @Autowired
    ProfileRepository profileRepository;

    @Override
    public Profile createProfile(Profile profile) { return profileRepository.save(profile);}

    @Override
    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    @Override
    public Profile getProfileById(Long id) {
        return profileRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Profile with id: " + id + " does not exist."));
    }

    @Override
    public Profile updateProfile(Profile profile, Long id) {
        Profile existingUser = getProfileById(id);
        existingUser.setAge(profile.getAge());
        existingUser.setSex(profile.getSex());
        existingUser.setCellphone(profile.getCellphone());
        return profileRepository.save(existingUser);
    }



}

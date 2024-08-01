package com.example.demo.service;

import com.example.demo.entity.Profile;
import com.example.demo.repo.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DemoService {

  private ProfileRepository profileRepository;

  public DemoService(ProfileRepository profileRepository) {
    this.profileRepository = profileRepository;
  }

  public String processCount(String count) {
    return "Here is a count: " + count;
  }

  public void updateProfile(Profile profile) {
    System.out.println("Here is  your profile ".concat(profile.toString()));
  }

  public void saveProfile(Profile profile) {
    profileRepository.save(profile);
  }

  public List<Profile> getAll() {
    return profileRepository.findAll().stream().sorted(Comparator.comparing(Profile::getAge)).collect(Collectors.toList());
  }
}

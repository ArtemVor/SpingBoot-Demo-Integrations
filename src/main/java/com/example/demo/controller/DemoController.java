package com.example.demo.controller;

import com.example.demo.entity.Profile;
import com.example.demo.service.DemoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/demo")
public class DemoController {

  private final DemoService demoService;

  public DemoController(DemoService demoService) {
    this.demoService = demoService;
  }

  @GetMapping("/{count}")
  public String getString(@PathVariable String count) {
    return demoService.processCount(count);
  }

  @PostMapping("/setProfile")
  public void receiveProfile(@RequestBody Profile profile) {
    demoService.updateProfile(profile);
  }

  @PostMapping("/save")
  public void saveProfile(@RequestBody Profile profile) {
    demoService.saveProfile(profile);
  }
  @GetMapping("/getAll")
  public List<Profile> getAll(){
    return demoService.getAll();
  }
}

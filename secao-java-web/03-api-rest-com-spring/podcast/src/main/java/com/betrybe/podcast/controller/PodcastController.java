package com.betrybe.podcast.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/podcasts")
public class PodcastController {

  @RequestMapping(method=RequestMethod.GET)
  public String getRoot() {
    return "Yay podcasts!";
  }
}

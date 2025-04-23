package com.betrybe.podcast.controller;

import com.betrybe.podcast.model.Podcast;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/podcasts")
public class PodcastController {

  @GetMapping
  public String getRoot() {
    return "Yay podcasts!";
  }

  @GetMapping("/{id}")
  public ResponseEntity<Podcast> getPodcast(@PathVariable Long id) {
    if (id > 1000) {
      return ResponseEntity.notFound().build();
    }

    Podcast podcast = new Podcast();
    podcast.setId(id);
    podcast.setName("Meu podcast");
    podcast.setUrl("http://www.meupodcast.com.br");
    return ResponseEntity.ok(podcast);
  }

  @GetMapping("/search")
  public String searchPodcast(@RequestParam String title) {
    return "Você buscou por Podcasts com o título: %s".formatted(title);
  }
}

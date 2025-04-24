package com.betrybe.podcast.controller;

import com.betrybe.podcast.dto.PodcastCreationDTO;
import com.betrybe.podcast.dto.PodcastDTO;
import com.betrybe.podcast.model.Podcast;
import com.betrybe.podcast.service.PodcastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/podcasts")
public class PodcastController {
  private PodcastService service;

  @Autowired
  public PodcastController(PodcastService service) {
    this.service = service;
  }

  @GetMapping
  public String getRoot() {
    return "Yay podcasts!";
  }

  @GetMapping("/{id}")
  public ResponseEntity<PodcastDTO> getPodcast(@PathVariable Long id) {
    if (id > 1000) {
      return ResponseEntity.notFound().build();
    }
    Podcast podcast = service.findPodcastById(id);

    PodcastDTO podcastDTO = new PodcastDTO(
        podcast.getId(), podcast.getName(), podcast.getUrl()
    );

    return ResponseEntity.ok(podcastDTO);
  }

  @GetMapping("/search")
  public String searchPodcast(@RequestParam String title) {
    return "Você buscou por Podcasts com o título: %s".formatted(title);
  }

  @PostMapping
  public ResponseEntity<PodcastDTO> newPodcast(@RequestBody PodcastCreationDTO podcastCreationDTO) {
    Podcast newPodcast = new Podcast();
    newPodcast.setName(podcastCreationDTO.name());
    newPodcast.setUrl(podcastCreationDTO.url());

    Podcast savedPodcast = service.savePodcast(newPodcast);

    PodcastDTO podcastDTO = new PodcastDTO(
        savedPodcast.getId(),
        savedPodcast.getName(),
        savedPodcast.getUrl()
    );

    return ResponseEntity.status(HttpStatus.CREATED).body(podcastDTO);
  }
}

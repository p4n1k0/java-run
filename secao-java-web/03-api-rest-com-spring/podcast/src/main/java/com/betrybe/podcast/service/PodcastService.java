package com.betrybe.podcast.service;

import com.betrybe.podcast.model.Podcast;
import org.springframework.stereotype.Service;

@Service
public class PodcastService {
  public Podcast findPodcastById(Long id) {
    Podcast podcast = new Podcast();
    podcast.setId(id);
    podcast.setName("Meu podcast");
    podcast.setUrl("http://www.meupodcast.com.br");

    return podcast;
  }
}

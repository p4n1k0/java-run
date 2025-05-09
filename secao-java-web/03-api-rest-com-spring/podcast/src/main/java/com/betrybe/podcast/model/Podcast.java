package com.betrybe.podcast.model;

public class Podcast {
  private Long id;
  private String name;
  private String url;
  private String secretToken;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getSecretToken() {
    return secretToken;
  }

  public void setSecretToken(String secretToken) {
    this.secretToken = secretToken;
  }
}

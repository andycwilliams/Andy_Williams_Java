package com.company.musicstorerecommendations.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "artist")
public class Artist implements Serializable {

    public Artist(){}

    public Artist(Integer artistRecommendationId, Integer artistId, Integer userId, Boolean liked) {
        this.artistRecommendationId = artistRecommendationId;
        this.artistId = artistId;
        this.userId = userId;
        this.liked = liked;
    }

    public Artist(Integer artistId, Integer userId, Boolean liked) {
        this.artistId = artistId;
        this.userId = userId;
        this.liked = liked;
    }

    @Id
    @Column(name = "artist_recommendation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer artistRecommendationId;

    @Column(name = "artist_id")
    private Integer artistId;

    @Column(name = "user_id")
    private Integer userId;

    private Boolean liked;

    public Integer getArtistRecommendationId() {
        return artistRecommendationId;
    }

    public void setArtistRecommendationId(Integer artistRecommendationId) {
        this.artistRecommendationId = artistRecommendationId;
    }

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Boolean getLiked() {
        return liked;
    }

    public void setLiked(Boolean liked) {
        this.liked = liked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return Objects.equals(artistRecommendationId, artist.artistRecommendationId) && Objects.equals(artistId, artist.artistId) && Objects.equals(userId, artist.userId) && Objects.equals(liked, artist.liked);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artistRecommendationId, artistId, userId, liked);
    }

    @Override
    public String toString() {
        return "Artist{" +
                "artistRecommendationId=" + artistRecommendationId +
                ", artistId=" + artistId +
                ", userId=" + userId +
                ", liked=" + liked +
                '}';
    }
}

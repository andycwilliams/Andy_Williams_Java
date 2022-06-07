package com.company.musicstorerecommendations.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "album")
public class Album implements Serializable {

    public Album( ) {}

    public Album(Integer albumRecommendationId, Integer albumId, Integer userId, Boolean liked) {
        this.albumRecommendationId = albumRecommendationId;
        this.albumId = albumId;
        this.userId = userId;
        this.liked = liked;
    }

    public Album(Integer albumId, Integer userId, Boolean liked) {
        this.albumId = albumId;
        this.userId = userId;
        this.liked = liked;
    }

    @Id
    @Column(name = "album_recommendation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer albumRecommendationId;

    @Column(name = "album_id")
    private Integer albumId;

    @Column(name = "user_id")
    private Integer userId;

    private Boolean liked;

    public Integer getAlbumRecommendationId() {
        return albumRecommendationId;
    }

    public void setAlbumRecommendationId(Integer albumRecommendationId) {
        this.albumRecommendationId = albumRecommendationId;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
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
        Album album = (Album) o;
        return Objects.equals(albumRecommendationId, album.albumRecommendationId) && Objects.equals(albumId, album.albumId) && Objects.equals(userId, album.userId) && Objects.equals(liked, album.liked);
    }

    @Override
    public int hashCode() {
        return Objects.hash(albumRecommendationId, albumId, userId, liked);
    }

    @Override
    public String toString() {
        return "Album{" +
                "albumRecommendationId=" + albumRecommendationId +
                ", albumId=" + albumId +
                ", userId=" + userId +
                ", liked=" + liked +
                '}';
    }
}

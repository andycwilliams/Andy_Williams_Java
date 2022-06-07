package com.company.musicstorerecommendations.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "label")
public class Label implements Serializable {

    public Label() {}

    public Label(Integer artistRecommendationId, Integer artistId, Integer userId, Boolean liked) {
        this.labelRecommendationId = artistRecommendationId;
        this.labelId = artistId;
        this.userId = userId;
        this.liked = liked;
    }

    public Label(Integer artistId, Integer userId, Boolean liked) {
        this.labelId = artistId;
        this.userId = userId;
        this.liked = liked;
    }

    @Id
    @Column(name = "label_recommendation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer labelRecommendationId;

    @Column(name = "label_id")
    private Integer labelId;

    @Column(name = "user_id")
    private Integer userId;

    private Boolean liked;

    public Integer getLabelRecommendationId() {
        return labelRecommendationId;
    }

    public void setLabelRecommendationId(Integer labelRecommendationId) {
        this.labelRecommendationId = labelRecommendationId;
    }

    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
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
        Label label = (Label) o;
        return Objects.equals(labelRecommendationId, label.labelRecommendationId) && Objects.equals(labelId, label.labelId) && Objects.equals(userId, label.userId) && Objects.equals(liked, label.liked);
    }

    @Override
    public int hashCode() {
        return Objects.hash(labelRecommendationId, labelId, userId, liked);
    }

    @Override
    public String toString() {
        return "Label{" +
                "labelRecommendationId=" + labelRecommendationId +
                ", labelId=" + labelId +
                ", userId=" + userId +
                ", liked=" + liked +
                '}';
    }
}

package com.company.musicstorecatalog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "album"})
@Table(name = "artist")
public class Artist implements Serializable {

    public Artist() {}
    public Artist(Integer id, String name, String instagram, String twitter) {
        this.id = id;
        this.name = name;
        this.instagram = instagram;
        this.twitter = twitter;
    }
    public Artist(String name, String instagram, String twitter) {
        this.name = name;
        this.instagram = instagram;
        this.twitter = twitter;
    }

    @Id
    @Column(name = "artist_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "artist_id")
    private Set<Album> albums = new HashSet<>();

    private String name;
    private String instagram;
    private String twitter;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return Objects.equals(id, artist.id) && Objects.equals(albums, artist.albums) && Objects.equals(name, artist.name) && Objects.equals(instagram, artist.instagram) && Objects.equals(twitter, artist.twitter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, albums, name, instagram, twitter);
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", albums=" + albums +
                ", name='" + name + '\'' +
                ", instagram='" + instagram + '\'' +
                ", twitter='" + twitter + '\'' +
                '}';
    }
}

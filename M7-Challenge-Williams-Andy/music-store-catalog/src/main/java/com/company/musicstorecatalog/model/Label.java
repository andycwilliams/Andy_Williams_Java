package com.company.musicstorecatalog.model;

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
    public Label(Integer id, String name, String website) {
        this.id = id;
        this.name = name;
        this.website = website;
    }
    public Label(String name, String website) {
        this.name = name;
        this.website = website;
    }

    @Id
    @Column(name = "label_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "label_id")
    private Set<Album> albums = new HashSet<>();

    private String name;
    private String website;

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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Label label = (Label) o;
        return Objects.equals(id, label.id) && Objects.equals(albums, label.albums) && Objects.equals(name, label.name) && Objects.equals(website, label.website);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, albums, name, website);
    }

    @Override
    public String toString() {
        return "Label{" +
                "id=" + id +
                ", albums=" + albums +
                ", name='" + name + '\'' +
                ", website='" + website + '\'' +
                '}';
    }
}

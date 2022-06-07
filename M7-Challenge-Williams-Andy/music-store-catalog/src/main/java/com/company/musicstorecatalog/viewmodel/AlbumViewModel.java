package com.company.musicstorecatalog.viewmodel;

import com.company.musicstorecatalog.model.Artist;
import com.company.musicstorecatalog.model.Label;
import com.company.musicstorecatalog.model.Track;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AlbumViewModel {
    public AlbumViewModel(Integer id, String title, Artist artist, LocalDate releaseDate, Label label, BigDecimal listPrice, List<Track> tracks) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.releaseDate = releaseDate;
        this.label = label;
        this.listPrice = listPrice;
        this.tracks = tracks;
    }

    public AlbumViewModel(String title, Artist artist, LocalDate releaseDate, Label label, BigDecimal listPrice, List<Track> tracks) {
        this.title = title;
        this.artist = artist;
        this.releaseDate = releaseDate;
        this.label = label;
        this.listPrice = listPrice;
        this.tracks = tracks;
    }

    public AlbumViewModel() {
    }

    private Integer id;
    private String title;
    private Artist artist;
    @Column(name = "release_date")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;
    private Label label;
    @Column(name = "list_price")
    private BigDecimal listPrice;
    private List<Track> tracks = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public BigDecimal getListPrice() {
        return listPrice;
    }

    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlbumViewModel that = (AlbumViewModel) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(artist, that.artist) && Objects.equals(releaseDate, that.releaseDate) && Objects.equals(label, that.label) && Objects.equals(listPrice, that.listPrice) && Objects.equals(tracks, that.tracks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, artist, releaseDate, label, listPrice, tracks);
    }

    @Override
    public String toString() {
        return "AlbumViewModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", artist=" + artist +
                ", releaseDate=" + releaseDate +
                ", label=" + label +
                ", listPrice=" + listPrice +
                ", tracks=" + tracks +
                '}';
    }
}

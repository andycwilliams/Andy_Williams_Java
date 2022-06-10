package com.company.musicstorecatalog.repository;

import com.company.musicstorecatalog.model.Artist;
import com.company.musicstorecatalog.model.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer> {
}

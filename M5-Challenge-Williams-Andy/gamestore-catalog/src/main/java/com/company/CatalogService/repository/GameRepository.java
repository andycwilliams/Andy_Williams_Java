package com.company.CatalogService.repository;

import com.company.CatalogService.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> findAllByEsrbRating(String esrbRating);
    List<Game> findAllByStudio(String studio);
    List<Game> findAllByTitle(String title);
}

package com.company.CatalogService.repository;

import com.company.CatalogService.model.TShirt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TShirtRepository extends JpaRepository<TShirt, Long> {
    List<TShirt> findAllByColor(String color);
    List<TShirt> findAllBySize(String size);
}

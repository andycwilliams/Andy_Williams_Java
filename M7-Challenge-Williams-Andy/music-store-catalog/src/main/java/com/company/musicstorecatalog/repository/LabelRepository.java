package com.company.musicstorecatalog.repository;

import com.company.musicstorecatalog.model.Label;
import com.company.musicstorecatalog.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabelRepository extends JpaRepository<Label, Integer> {
}

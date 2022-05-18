package com.example.demo3.repositories;

import com.example.demo3.entities.Document;
import com.example.demo3.entities.Section;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface SectionsRepository extends CrudRepository<Section, Integer> {
    List<Section> findByDocument(Document document);
}
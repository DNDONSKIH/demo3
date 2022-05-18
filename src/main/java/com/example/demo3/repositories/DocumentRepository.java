package com.example.demo3.repositories;

import com.example.demo3.entities.Document;
import org.springframework.data.repository.CrudRepository;

public interface DocumentRepository extends CrudRepository<Document, Integer> {
}
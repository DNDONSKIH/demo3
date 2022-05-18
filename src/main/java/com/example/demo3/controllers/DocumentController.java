package com.example.demo3.controllers;

import com.example.demo3.entities.Document;
import com.example.demo3.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DocumentController {
    @Autowired
    private DocumentRepository documentRepository;

    @PostMapping("/documents")
    public String createDocument(@RequestBody Document document) {
        Document createdDocument = documentRepository.save(document);
        String responseTemplate = """
                {
                    "id" : %d ,
                    "success" : true,
                    "msg" : "ok"
                }
                """;
        String response = String.format(responseTemplate, createdDocument.getId());
        return response;
    }

    @GetMapping("/documents")
    public List<Document> getAllDocuments() {
        return (List<Document>) documentRepository.findAll();
    }

    @PutMapping("/documents/{documentId}")
    public void updateDocument(@RequestBody Document document, @PathVariable Integer documentId) {
        Document patchedDocument = documentRepository.findById(documentId).orElse(new Document());
        if(document.getHeader() != null) patchedDocument.setHeader(document.getHeader());
        if(document.getFooter() != null) patchedDocument.setFooter(document.getFooter());
        if(document.getDescription() != null) patchedDocument.setDescription(document.getDescription());
        documentRepository.save(patchedDocument);
    }

    @DeleteMapping("/documents/{documentId}")
    public void deleteDocument(@RequestBody Document document) {
        documentRepository.deleteById(document.getId());
    }
}

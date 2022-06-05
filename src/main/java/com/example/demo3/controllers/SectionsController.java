package com.example.demo3.controllers;

import com.example.demo3.entities.Document;
import com.example.demo3.entities.Section;
import com.example.demo3.repositories.SectionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SectionsController {
    @Autowired
    private SectionsRepository sectionsRepository;

    @GetMapping("/sections")
    public List<Section> getAllSections() {
        return (List<Section>) sectionsRepository.findAll();
    }

    @PutMapping("/sections/{sectionId}")
    public void updateSection2(@RequestBody Section section,
                              @PathVariable Integer sectionId) {
        var emptySection = new Section(new Document());
        Section patchedSection = sectionsRepository.findById(sectionId).orElse(emptySection);
        if(section.getTitle() != null) patchedSection.setTitle(section.getTitle());
        if(section.getText() != null) patchedSection.setText(section.getText());
        sectionsRepository.save(patchedSection);
    }

    @DeleteMapping("/sections/{sectionId}")
    public void deleteSection2(@RequestBody Section section) {
        sectionsRepository.deleteById(section.getId());
    }

    @PostMapping("/sections")
    public String createSection2(@RequestParam("title") String title,
                                 @RequestParam("text") String text,
                                @RequestParam("documentId") Integer documentId ) {
        var section = new Section(title, text, new Document(documentId));
        Section createdSection = sectionsRepository.save(section);
        String responseTemplate = """
                {
                    "id" : %d ,
                    "success" : true,
                    "msg" : "ok"
                }
                """;
        String response = String.format(responseTemplate, createdSection.getId());
        return response;
    }






    @PostMapping("/documents/{documentId}/sections")
    public String createSection(@RequestBody Section section,
                                 @PathVariable Integer documentId ) {
        section.setDocument(new Document(documentId));
        Section createdSection = sectionsRepository.save(section);
        String responseTemplate = """
                {
                    "id" : %d ,
                    "success" : true,
                    "msg" : "ok"
                }
                """;
        String response = String.format(responseTemplate, createdSection.getId());
        return response;
    }

    @GetMapping("/documents/{documentId}/sections")
    public List<Section> getSections(@PathVariable Integer documentId) {
        return sectionsRepository.findByDocument(new Document(documentId));
    }

    @PutMapping("/documents/{documentId}/sections/{sectionId}")
    public void updateSection(@RequestBody Section section,
                               @PathVariable Integer documentId,
                               @PathVariable Integer sectionId) {
        var emptySection = new Section(new Document(documentId));
        Section patchedSection = sectionsRepository.findById(sectionId).orElse(emptySection);
        if(section.getTitle() != null) patchedSection.setTitle(section.getTitle());
        if(section.getText() != null) patchedSection.setText(section.getText());
        sectionsRepository.save(patchedSection);
    }

    @DeleteMapping("/documents/{documentId}/sections/{sectionId}")
    public void deleteSection(@RequestBody Section section) {
        sectionsRepository.deleteById(section.getId());
    }

}

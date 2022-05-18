package com.example.demo3.controllers;

import com.example.demo3.entities.Document;
import com.example.demo3.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;


@Controller
public class DocumentViewController {
    @Autowired
    private DocumentRepository documentRepository;

    @RequestMapping("/view/{id}")
    public String document (@PathVariable Integer id, Model model) {
        Document document = documentRepository.findById(id).orElse(
                new Document("Документ не выбран","","", new ArrayList<>()));
        model.addAttribute("document", document);
        return "view";
    }
}


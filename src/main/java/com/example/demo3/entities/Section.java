package com.example.demo3.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Section {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String text;
    @ManyToOne
    @JoinColumn(name="document_id")
    private Document document;

    public Section(Document document) {
        this.document = document;
    }

    @JsonIgnore
    public Document getDocument() { return document; }
}
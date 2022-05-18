package com.example.demo3.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Document {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String header;
    private String footer;
    private String description;
    @OneToMany( targetEntity = Section.class, mappedBy = "document",
            cascade = CascadeType.ALL/*, fetch = FetchType.EAGER*/)
    private List<Section> sectionList;

    public Document(Integer id) {
        this.id = id;
    }

    public Document(String header, String footer, String description, List<Section> sectionList) {
        this.header = header;
        this.footer = footer;
        this.description = description;
        this.sectionList = sectionList;
    }

    @JsonIgnore
    public List<Section> getSectionList() { return sectionList; }
}

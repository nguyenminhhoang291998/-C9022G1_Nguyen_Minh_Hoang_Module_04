package com.example.blog.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String summary;
    @Column(columnDefinition = "longtext")
    private String content;

    private LocalDate createdDay;

    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;

    public Blog(int id, String summary, String content, LocalDate createdDay, Category category) {
        this.id = id;
        this.summary = summary;
        this.content = content;
        this.createdDay = createdDay;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public LocalDate getCreatedDay() {
        return createdDay;
    }

    public void setCreatedDay(LocalDate createdDay) {
        this.createdDay = createdDay;
    }


    public Blog(int id, String summary, String content, LocalDate createdDay) {
        this.id = id;
        this.summary = summary;
        this.content = content;
        this.createdDay = createdDay;
    }

    public Blog() {
    }

//    public Blog(int id, String summary, String content) {
//        this.id = id;
//        this.summary = summary;
//        this.content = content;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

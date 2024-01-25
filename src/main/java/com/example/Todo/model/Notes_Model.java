package com.example.Todo.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "notes")
public class Notes_Model {
    @Id
    private ObjectId id_;

    private String title;
    private String description;

    public ObjectId getId_() {
        return id_;
    }

    public void setId_(ObjectId id_) {
        this.id_ = id_;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

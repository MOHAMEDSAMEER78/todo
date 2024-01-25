package com.example.Todo.repository;

import com.example.Todo.model.Notes_Model;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface Notes_Repository extends MongoRepository<Notes_Model, String> {

    Notes_Model findByTitle(String title);
}

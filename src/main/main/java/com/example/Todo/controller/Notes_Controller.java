package com.example.Todo.controller;

import com.example.Todo.repository.Notes_Repository;
import com.example.Todo.model.Notes_Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;

@RestController
public class Notes_Controller {
    @Autowired
    private final Notes_Repository note_Repository;

    public Notes_Controller(Notes_Repository note_Repository) {
        this.note_Repository = note_Repository;
    }

    @GetMapping("/fetch_all_notes")
    public ResponseEntity<List<Notes_Model>> getAllNotes() {
        return ResponseEntity.ok(note_Repository.findAll());
    }

    @PostMapping("/create_note")
    public ResponseEntity<Notes_Model> createNotes(@RequestBody Notes_Model notes) {

       var result = note_Repository.save(notes);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update_note")
    public ResponseEntity updateNotes(@RequestBody Notes_Model notes) {
        var foundnotes = note_Repository.findByTitle(notes.getTitle());
        if(Objects.isNull(foundnotes)){
            return ResponseEntity.ok("Notes withe Given Title not found");
        }
        foundnotes.setDescription(notes.getDescription());
        var result = note_Repository.save(foundnotes);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete_note")
    public ResponseEntity deleteNotes(@RequestBody Notes_Model notes) {
        var foundnotes = note_Repository.findByTitle(notes.getTitle());
        if(Objects.isNull(foundnotes)){
            return ResponseEntity.ok("Notes withe Given Title not found");
        }
        note_Repository.delete(foundnotes);
        return ResponseEntity.ok("Notes Deleted");
    }
}
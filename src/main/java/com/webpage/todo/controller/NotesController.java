package com.webpage.todo.controller;
import com.webpage.todo.model.notes;
import com.webpage.todo.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

public class NotesController {
    @Autowired
    private NotesService notesService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public notes createNotes(@RequestBody notes note) {
        return notesService.createNotes(note);
    }

    @GetMapping("/{id}")
    public notes getNotesById(String id) {
        return notesService.getNotesById(id);
    }

    @PutMapping("/{id}")
    public notes updateNotesById(String id, notes note) {
        return notesService.updateNotesById(id, note);
    }

    @DeleteMapping("/{id}")
    public void deleteNotesById(String id) {
        notesService.deleteNotesById(id);
    }

}

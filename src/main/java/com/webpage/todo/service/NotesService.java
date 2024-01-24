package com.webpage.todo.service;

import com.webpage.todo.model.notes;
import com.webpage.todo.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.ZonedDateTime;
import java.util.UUID;

public class NotesService {
    @Autowired
    private NoteRepository noteRepository;

    public notes createNotes(notes note) {
        note.setId(UUID.randomUUID().toString());
        note.setCreatedOn(ZonedDateTime.now());
        return noteRepository.save(note);
    }

    public notes getNotesById(String id) {
        return noteRepository.findById(id).get();
    }

    public notes updateNotesById(String id, notes note) {
        notes noteFromDb = noteRepository.findById(id).get();
        noteFromDb.setTitle(note.getTitle());
        noteFromDb.setContent(note.getContent());
        return noteRepository.save(noteFromDb);
    }

    public void deleteNotesById(String id) {
        noteRepository.deleteById(id);
    }
}

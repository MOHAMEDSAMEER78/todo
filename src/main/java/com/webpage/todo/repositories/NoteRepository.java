package com.webpage.todo.repositories;
import com.webpage.todo.model.notes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends MongoRepository<notes, String>{

}

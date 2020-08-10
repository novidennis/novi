package novi.spring.repository;

import novi.spring.model.notes.Note;
import novi.spring.model.users.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NoteRepository extends CrudRepository<Note, Integer> {
    List<Note> findAllByUser(User user);


}
package novi.spring.repository;

import novi.spring.model.notes.Comment;
import novi.spring.model.notes.Note;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Integer> {

    @Query("select _note from Comment _comment join _comment.user _user join _comment.note _note where _user.id = :id")
    List<Note> findNotesByUserComments(Long id);
}
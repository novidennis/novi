package novi.spring.repository;

import novi.spring.model.notes.Like;
import novi.spring.model.notes.Note;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LikeRepository extends CrudRepository<Like, Integer> {

    @Query("select _note from Like _like join _like.user _user join _like.note _note where _user.id = :id")
    List<Note> findNotesByUserLikes(Long id);
}

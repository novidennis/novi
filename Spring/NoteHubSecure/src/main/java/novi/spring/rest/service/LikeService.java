package novi.spring.rest.service;

import novi.spring.repository.LikeRepository;
import novi.spring.model.notes.Like;
import novi.spring.model.notes.Note;
import novi.spring.model.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;
import java.util.Date;
import java.util.List;

@Service
public class LikeService {

    @Autowired
    private UserService userService;

    @Autowired
    private NoteService noteService;

    @Autowired
    private LikeRepository likes;

    public String addLike(int noteId) throws SQLDataException {
        User user = userService.getActiveUser();
        Note note = noteService.getNoteById(noteId);

        Like like = new Like(note, user, new Date());
        likes.save(like);
        return "Like succesfully added";

    }


    public List<Note> getNotesFromUserLikes() throws SQLDataException {
        User user = userService.getActiveUser();
        return likes.findNotesByUserLikes(user.getId());
    }
}

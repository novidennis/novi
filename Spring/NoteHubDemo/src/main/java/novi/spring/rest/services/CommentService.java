package novi.spring.rest.services;

import novi.spring.repository.CommentRepository;
import novi.spring.model.notes.Comment;
import novi.spring.model.notes.Note;
import novi.spring.model.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.SQLDataException;
import java.util.List;

@Controller
public class CommentService {

    @Autowired
    private UserService userService;

    @Autowired
    private NoteService noteService;

    @Autowired
    private CommentRepository comments;

    public String addComment(int noteId, String text) throws SQLDataException {
        User user = userService.getActiveUser();
        Note note = noteService.getNoteById(noteId);

        Comment comment = new Comment(note, user, text);
        comments.save(comment);
        return "Comment succesfully added";
    }

    public List<Note> getNotesFromUserComments() throws SQLDataException {
        User user = userService.getActiveUser();
        return comments.findNotesByUserComments(user.getId());
    }
}

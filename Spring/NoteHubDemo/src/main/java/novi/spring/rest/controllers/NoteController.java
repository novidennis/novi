package novi.spring.rest.controllers;

import novi.spring.model.notes.Note;
import novi.spring.rest.data.request.CommentRequest;
import novi.spring.rest.data.request.NoteRequest;
import novi.spring.rest.services.CommentService;
import novi.spring.rest.services.LikeService;
import novi.spring.rest.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLDataException;
import java.util.List;

@RestController
@RequestMapping("api/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private LikeService likeService;

    //create note by user with tags
    @PostMapping("/create")
    public ResponseEntity<?> createNote(@RequestBody NoteRequest noteRequest) {
        try {
            String response = noteService.createNote(noteRequest);
            return ResponseEntity.ok(response);
        } catch (SQLDataException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //add comment to note by user
    @PostMapping("/{noteId}/addComment")
    public ResponseEntity<?> commentOnNote(@PathVariable int noteId, @RequestBody CommentRequest commentRequest) {
        try {
            String response = commentService.addComment(noteId, commentRequest.getText());
            return ResponseEntity.ok(response);
        } catch (SQLDataException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //add like to note by user
    @PostMapping("/{noteId}/addLike")
    public ResponseEntity<?> likeNote(@PathVariable int noteId) {
        try {
            String response = likeService.addLike(noteId);
            return ResponseEntity.ok(response);
        } catch (SQLDataException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //get notes from user
    @GetMapping("/fromUser")
    public ResponseEntity<?> getNotesFromUser() {
        try {
            List<Note> notesFromUser = noteService.getNotesFromUser();
            return ResponseEntity.ok(notesFromUser);
        } catch (SQLDataException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //get notes from user comments
    @GetMapping("/fromUserComments")
    public ResponseEntity<?> getNotesFromUserComments() {
        try {
            List<Note> notesFromUserComments = commentService.getNotesFromUserComments();
            return ResponseEntity.ok(notesFromUserComments);
        } catch (SQLDataException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //get notes from user likes
    @GetMapping("/fromUserLikes")
    public ResponseEntity<?> getNotesFromUserLikes() {
        try {
            List<Note> notesFromUserLikes = likeService.getNotesFromUserLikes();
            return ResponseEntity.ok(notesFromUserLikes);
        } catch (SQLDataException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

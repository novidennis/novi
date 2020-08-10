package novi.spring.rest.controller;

import novi.spring.model.notes.Note;
import novi.spring.rest.data.request.CommentRequest;
import novi.spring.rest.data.request.NoteRequest;
import novi.spring.rest.service.CommentService;
import novi.spring.rest.service.LikeService;
import novi.spring.rest.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLDataException;
import java.util.List;

@RestController
@RequestMapping("api/service/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private LikeService likeService;

    //create note by user with tags
    @PostMapping("/create")
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
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
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
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
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
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
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
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
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
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
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    public ResponseEntity<?> getNotesFromUserLikes() {
        try {
            List<Note> notesFromUserLikes = likeService.getNotesFromUserLikes();
            return ResponseEntity.ok(notesFromUserLikes);
        } catch (SQLDataException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
